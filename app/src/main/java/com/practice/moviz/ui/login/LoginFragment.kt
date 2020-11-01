package com.practice.moviz.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.google.firebase.auth.ktx.actionCodeSettings
import com.google.firebase.auth.ktx.auth
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import com.google.firebase.ktx.Firebase
import com.practice.moviz.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.login_fragment.*

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by navGraphViewModels(R.id.nav_graph){
        defaultViewModelProviderFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        login_btn_login.setOnClickListener{
            val actionCodeSettings = actionCodeSettings {
                url = "https://moviz.page.link/main"
                // This must be true
                handleCodeInApp = true
                setAndroidPackageName(
                    "com.practice.moviz",
                    true,
                    null)
            }
            Firebase.auth
                .sendSignInLinkToEmail(editTextTextPersonName.text.toString(), actionCodeSettings)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("Email Tag", "Email sent.")
                        val editor = requireActivity().getPreferences(Context.MODE_PRIVATE).edit()
                        editor.putString("email", editTextTextPersonName.text.toString())
                        editor.apply()
                    }
                }
        }

        val auth = Firebase.auth
        val intent = requireActivity().intent
        val emailLink = intent.data.toString()

        if (auth.isSignInWithEmailLink(emailLink)) {
            val email = requireActivity().getPreferences(Context.MODE_PRIVATE).getString("email", "none found")!!

            auth.signInWithEmailLink(email, emailLink)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val result = task.result
                        val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
                        findNavController().navigate(action)
                    } else {
                        Log.e("failed login", "Error signing in with email link", task.exception)
                    }
                }
        }
    }

}
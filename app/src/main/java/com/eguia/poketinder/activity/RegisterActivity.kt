package com.eguia.poketinder.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.eguia.poketinder.data.User
import com.eguia.poketinder.databinding.ActivityRegisterBinding
import com.eguia.poketinder.util.SharedPreferenceUtil

class RegisterActivity: BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate) {

    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(this)
        }
    }

    fun registerUser(view: View){
        binding.tvUserName.visibility = View.GONE
        binding.tvEmail.visibility = View.GONE
        binding.tvPassword.visibility = View.GONE

        if(binding.edtUserName.text.isEmpty()){
            binding.tvUserName.visibility = View.VISIBLE
            binding.tvUserName.setText("Ingrese el Nombre de Usuario")
        }
        else if(binding.edtEmail.text.isEmpty()){
            binding.tvEmail.visibility = View.VISIBLE
            binding.tvEmail.setText("Ingrese el Email")
        }
        else if(binding.edtPassword.text.isEmpty() || binding.edtPassword2.text.isEmpty()){
            binding.tvPassword.visibility = View.VISIBLE
            binding.tvPassword.setText("Ingrese el Password")
        }
        else if(binding.edtPassword.text.toString() != binding.edtPassword2.text.toString()){
            binding.tvPassword.visibility = View.VISIBLE
            binding.tvPassword.setText("El Password no coincide")
        }else{
            val user = User(
                "1",
                binding.edtUserName.text.toString(),
                binding.edtEmail.text.toString(),
                binding.edtPassword.text.toString())

            sharedPreferenceUtil.saveFacebookUser(user)
            val intent = Intent(applicationContext, LoginActivity::class.java)
            intent.putExtra("user",user)
            startActivity(intent)
        }
    }

    fun loginUser(view:View){
        val intent = Intent(applicationContext, LoginActivity::class.java)

        startActivity(intent)
    }
}
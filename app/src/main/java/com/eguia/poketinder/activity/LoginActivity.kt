package com.eguia.poketinder.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.eguia.poketinder.data.User
import com.eguia.poketinder.databinding.ActivityLoginBinding
import com.eguia.poketinder.util.SharedPreferenceUtil


class LoginActivity: BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        sharedPreferenceUtil=SharedPreferenceUtil().also{
            it.setSharedPreference(this)
        }
    }

    fun validateInput(){
        if(binding.edtEmail.text.isEmpty() && binding.edtPassword.text.isEmpty()){
            //Agregar toast
        }
    }

    fun startLogin(view: View){
        binding.tvEdtEmail.visibility = View.GONE
        binding.tvEdtPassword.visibility = View.GONE
        //validateInput()
        if(binding.edtEmail.text.isEmpty()){
            binding.tvEdtEmail.visibility = View.VISIBLE
            binding.tvEdtEmail.setText("Ingrese el Email")
        }else if(binding.edtPassword.text.isEmpty()){
            binding.tvEdtPassword.visibility = View.VISIBLE
            binding.tvEdtPassword.setText("Ingrese el Password")
        }else{
            val user: User? = sharedPreferenceUtil.getUser()

            if(user?.email.equals(binding.edtEmail.text.toString()) && user?.password.equals(binding.edtPassword.text.toString())){
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("user", user)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Error Usuario",Toast.LENGTH_SHORT).show()
            }
        }

    }
}
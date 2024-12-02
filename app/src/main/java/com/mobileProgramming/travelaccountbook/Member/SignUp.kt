package com.example.yourapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import android.widget.Toast
import com.mobileProgramming.travelaccountbook.R

class SignUp : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)

        val etName = view.findViewById<EditText>(R.id.et_name)
        val etId = view.findViewById<EditText>(R.id.et_id)
        val etPassword = view.findViewById<EditText>(R.id.et_password)
        val etPasswordConfirm = view.findViewById<EditText>(R.id.et_password_confirm)
        val rgGender = view.findViewById<RadioGroup>(R.id.rg_gender)
        val etAge = view.findViewById<EditText>(R.id.et_age)
        val etEmail = view.findViewById<EditText>(R.id.et_email)
        val btnSignup = view.findViewById<Button>(R.id.btn_signup)

        btnSignup.setOnClickListener {
            val name = etName.text.toString()
            val id = etId.text.toString()
            val password = etPassword.text.toString()
            val passwordConfirm = etPasswordConfirm.text.toString()
            val age = etAge.text.toString()
            val email = etEmail.text.toString()

            val gender = when (rgGender.checkedRadioButtonId) {
                R.id.rb_male -> "남자"
                R.id.rb_female -> "여자"
                else -> ""
            }

            if (password != passwordConfirm) {
                Toast.makeText(context, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(
                context,
                "회원가입 완료: 이름 $name, 아이디 $id, 성별 $gender, 나이 $age, 이메일 $email",
                Toast.LENGTH_LONG
            ).show()
        }

        return view
    }
}

package com.homindolentrahar.finconc.ui.settings

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.TextView
import com.google.android.material.switchmaterial.SwitchMaterial
import com.homindolentrahar.finconc.R
import com.homindolentrahar.finconc.databinding.ActivitySettingsBinding
import com.homindolentrahar.finconc.ui.profile.ProfileActivity

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingsBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar?.title = "Setting Profile"

        val tvStatus = findViewById<TextView>(R.id.tv_status)
        val switchStatus = findViewById<SwitchMaterial>(R.id.switch_status)
        val btnSave = findViewById<Button>(R.id.btn_save)
        val rgGender = findViewById<RadioGroup>(R.id.radio_gender)
        val checkAmcc = findViewById<CheckBox>(R.id.chck_amcc)
        val checkHimmsi = findViewById<CheckBox>(R.id.chck_himssi)
        val checkBem = findViewById<CheckBox>(R.id.chk_bem)

        switchStatus.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                tvStatus.text = "Aktif"
            } else {
                tvStatus.text = "Tidak Aktif"
            }
        }

        btnSave.setOnClickListener {
            val orgs = StringBuilder()

            if (checkAmcc.isChecked) {
                orgs.append("AMCC")
            }

            if (checkHimmsi.isChecked) {
                orgs.append("HIMMSI")
            }

            if (checkBem.isChecked) {
                orgs.append("BEM")
            }

            val bundle = Bundle()
            bundle.apply {
                putString("name", binding.editName.text.toString())
                putString("nim", binding.editId.text.toString())
                putString("email", binding.editEmail.text.toString())
                putString("phone", binding.editPhone.text.toString())
                putString("gender", binding.radioGender.checkedRadioButtonId.toString())
                putString("major", binding.spinnerMajor.selectedItem.toString())
                putString("orgs", orgs.toString())
                putString("status", switchStatus.text.toString())

                if (!Patterns.EMAIL_ADDRESS.matcher(binding.editEmail.text.toString()).matches()) {
                    binding.editEmail.error = "Email invalid!"
                } else if (binding.editPassword.text.toString().length < 6) {
                    binding.editPassword.error = "Password too short!"
                } else {
                    AlertDialog.Builder(this@SettingsActivity).apply {
                        setTitle("Saving Data?")
                        setMessage("Sure saving data")
                        setCancelable(false)
                        setPositiveButton("Yes") { _, _ ->
                            val profileIntent =
                                Intent(this@SettingsActivity, ProfileActivity::class.java)
                            profileIntent.apply {
                                putExtras(bundle)
                            }.let {
                                startActivity(it)
                            }
                        }
                        setNegativeButton("No") { dialogInterface, _ ->
                            dialogInterface.cancel()
                        }
                        show()
                    }
                }
            }
        }
    }
}
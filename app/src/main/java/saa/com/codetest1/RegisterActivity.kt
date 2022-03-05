package saa.com.codetest1

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.register_activity.*
import java.text.SimpleDateFormat
import java.util.*


class RegisterActivity : AppCompatActivity() {

    private val cal = Calendar.getInstance()
    private var dob:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)


        val y = cal.get(Calendar.YEAR)
        val m = cal.get(Calendar.MONTH)
        val d = cal.get(Calendar.DAY_OF_MONTH)

        imgDob.setOnClickListener {
            DatePickerDialog(this, { _, _, _, _ ->
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.US)
                dob = sdf.format(cal.time)
                txtDob.setText(dob)
            }, y, m, d).show()
        }

        btnCreateAccount.setOnClickListener {
            if(checkUserInput()){

            }else{
                Toast.makeText(applicationContext,"Please enter required fields!",Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun checkUserInput():Boolean{
        var bFirstName = if(edtFristName.text.trim().isEmpty()){
            edtFristName.backgroundTintList = resources.getColorStateList(R.color.bgError)
            false
        }else{
            edtFristName.backgroundTintList = null
            true
        }

        var bLastName = if(edtLastName.text.trim().isEmpty()){
            edtLastName.backgroundTintList = resources.getColorStateList(R.color.bgError)
            false
        }else{
            edtLastName.backgroundTintList = null
            true
        }

        var bEmail = if(edtEmail.text.trim().isEmpty()){
            edtEmail.backgroundTintList = resources.getColorStateList(R.color.bgError)
            false
        }else{
            edtEmail.backgroundTintList = null
            true
        }

        var bDob = if(dob.isEmpty()){
            txtDob.backgroundTintList = resources.getColorStateList(R.color.bgError)
            false
        }else{
            txtDob.backgroundTintList = null
            true
        }

        var bNationality = if(edtNationality.text.trim().isEmpty()){
            edtNationality.backgroundTintList = resources.getColorStateList(R.color.bgError)
            false
        }else{
            edtNationality.backgroundTintList = null
            true
        }

        var bResidence = if(edtResidence.text.trim().isEmpty()){
            edtResidence.backgroundTintList = resources.getColorStateList(R.color.bgError)
            false
        }else{
            edtResidence.backgroundTintList = null
            true
        }




        return bFirstName && bLastName && bEmail && bDob && bNationality && bResidence;
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        outState.putString("firstName",edtFristName.text.toString())
        outState.putString("lastName",edtLastName.text.toString())
        outState.putString("emailAddress",edtEmail.text.toString())
        outState.putString("dob", dob)
        outState.putString("nationality",edtNationality.text.toString())
        outState.putString("country",edtResidence.text.toString())
        outState.putString("countryCode",edtPhoneCountryCode.text.toString())
        outState.putString("phoneNo",edtPhoneNo.text.toString())

        super.onSaveInstanceState(outState, outPersistentState)

    }

    override fun onRestoreInstanceState(bundle: Bundle) {
        if(!bundle.isEmpty){
            edtFristName.setText(bundle.getString("firstName",""))
            edtLastName.setText(bundle.getString("lastName",""))
            edtEmail.setText(bundle.getString("emailAddress",""))
            txtDob.setText(bundle.getString("dob",""))
            edtNationality.setText(bundle.getString("nationality",""))
            edtResidence.setText(bundle.getString("country",""))
            edtPhoneCountryCode.setText(bundle.getString("countryCode",""))
            edtPhoneNo.setText(bundle.getString("phoneNo",""))

        }
        super.onRestoreInstanceState(bundle)

    }



}
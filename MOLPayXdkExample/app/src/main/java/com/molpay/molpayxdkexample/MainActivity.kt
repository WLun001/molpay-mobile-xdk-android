package com.molpay.molpayxdkexample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import android.widget.TextView

import com.molpay.molpayxdk.MOLPayActivity

import java.util.HashMap

class MainActivity : AppCompatActivity() {

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == MOLPayActivity.MOLPayXDK && resultCode == Activity.RESULT_OK) {
            Log.d(MOLPayActivity.MOLPAY, "MOLPay result = " + data.getStringExtra(MOLPayActivity.MOLPayTransactionResult))
            val tw = findViewById(R.id.resultTV) as TextView
            tw.text = data.getStringExtra(MOLPayActivity.MOLPayTransactionResult)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val paymentDetails = HashMap<String, Any>()
        paymentDetails.put(MOLPayActivity.mp_amount, "")
        paymentDetails.put(MOLPayActivity.mp_username, "")
        paymentDetails.put(MOLPayActivity.mp_password, "")
        paymentDetails.put(MOLPayActivity.mp_merchant_ID, "")
        paymentDetails.put(MOLPayActivity.mp_app_name, "")
        paymentDetails.put(MOLPayActivity.mp_order_ID, "")
        paymentDetails.put(MOLPayActivity.mp_currency, "MYR")
        paymentDetails.put(MOLPayActivity.mp_country, "MY")
        paymentDetails.put(MOLPayActivity.mp_verification_key, "")
        paymentDetails.put(MOLPayActivity.mp_channel, "")
        paymentDetails.put(MOLPayActivity.mp_bill_description, "")
        paymentDetails.put(MOLPayActivity.mp_bill_name, "")
        paymentDetails.put(MOLPayActivity.mp_bill_email, "")
        paymentDetails.put(MOLPayActivity.mp_bill_mobile, "")

        //paymentDetails.put(MOLPayActivity.mp_channel_editing, false);
        //paymentDetails.put(MOLPayActivity.mp_editing_enabled, false);
        //paymentDetails.put(MOLPayActivity.mp_transaction_id, "");
        //paymentDetails.put(MOLPayActivity.mp_request_type, "");
        //String binlock[] = {"123456","234567"};
        //paymentDetails.put(MOLPayActivity.mp_bin_lock, binlock);
        //paymentDetails.put(MOLPayActivity.mp_bin_lock_err_msg, "Wrong BIN format");
        //paymentDetails.put(MOLPayActivity.mp_is_escrow, "");
        //paymentDetails.put(MOLPayActivity.mp_filter, "1");
        //paymentDetails.put(MOLPayActivity.mp_custom_css_url, "file:///android_asset/custom.css");
        //paymentDetails.put(MOLPayActivity.mp_preferred_token, "");
        //paymentDetails.put(MOLPayActivity.mp_tcctype, ""); // SALS // AUTH
        //paymentDetails.put(MOLPayActivity.mp_is_recurring, false);
        //String allowedchannels[] = {"credit","credit3"};
        //paymentDetails.put(MOLPayActivity.mp_allowed_channels, allowedchannels);
        //paymentDetails.put(MOLPayActivity.mp_sandbox_mode, true);
        //paymentDetails.put(MOLPayActivity.mp_express_mode, true);
        //paymentDetails.put(MOLPayActivity.mp_advanced_email_validation_enabled, true);
        //paymentDetails.put(MOLPayActivity.mp_advanced_phone_validation_enabled, true);
        //paymentDetails.put(MOLPayActivity.mp_bill_name_edit_disabled, true);
        //paymentDetails.put(MOLPayActivity.mp_bill_email_edit_disabled, true);
        //paymentDetails.put(MOLPayActivity.mp_bill_mobile_edit_disabled, true);
        //paymentDetails.put(MOLPayActivity.mp_bill_description_edit_disabled, true);
        //paymentDetails.put(MOLPayActivity.mp_language, "EN");
        //paymentDetails.put(MOLPayActivity.mp_dev_mode, false);

        val intent = Intent(this@MainActivity, MOLPayActivity::class.java)
        intent.putExtra(MOLPayActivity.MOLPayPaymentDetails, paymentDetails)
        startActivityForResult(intent, MOLPayActivity.MOLPayXDK)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }
}

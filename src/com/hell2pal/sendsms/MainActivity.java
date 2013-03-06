package com.hell2pal.sendsms;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button btnSend; // Button for sent
	EditText phoneNo; // EditText for phone number input
	EditText message; // EditText for your message content

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		/*Binding UI(XML) with java code*/ 
	btnSend = (Button)findViewById(R.id.btn_send);			// button initialization
	phoneNo = (EditText) findViewById(R.id.et_number);		
	message = (EditText) findViewById(R.id.et_message);

		/*Button click event listener: when button clicked */
	btnSend.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View v) {

		/*Writer your code here what you want to do on button clicked*/ 
			
		  String phone = phoneNo.getText().toString();		// get phone number
		  String sms = message.getText().toString();		// get message

		  try {
			SmsManager smsManager = SmsManager.getDefault();	// using default SmsManager
			
			smsManager.sendTextMessage(phone, null, sms, null, null);
			
		   /* The five parameters in sendTextMessage method
		    * String destinationAddress 	- 	phone
			* String scAddress  			-	null
			* String text					-	sms
			* PendingIntent sentIntent		-	null 
			* PendingIntent deliveryIntent	-	null
			* */
			 
			Toast.makeText(getApplicationContext(), "SMS Sent!",
						Toast.LENGTH_LONG).show();	
			/* Above code for showing toast message	- To know more about Toast Message
			 * please visit "How to use Toast message" on my blog. */
			
		  } catch (Exception e) {
			Toast.makeText(getApplicationContext(),
				"SMS faild, please try again later!",
				Toast.LENGTH_LONG).show();
			e.printStackTrace();
		  }

		}
	});
}
}

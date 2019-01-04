package com.ezerka.paymentpingo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.payu.india.Model.PaymentParams;
import com.payu.india.Payu.Payu;

public class MainActivity extends AppCompatActivity {

    private String merchantKey, userCredentials;

    private PaymentParams mPaymentParams;

    private Payuconfig payuconfig;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);

	Payu.setInstance(this);

	toolbar.setTitle("Checkout Screen");
	toolbar.setTitleTextColor(Color.BLUE);
	setSupportActionBar(toolbar);

	payuconfig = new Payuconfig();
    }

    public void navigateToBaseActivity(View view) {
	merchantKey = "gtKFFx";
	Object payuConstants = new Object();
	int environment = payuConstants.STAGINBG_ENE;
	String email = "payutest@gmail.com";
	String amount = "10";
	userCredentials = merchantKey + ":" + email;
	mPaymentParams = new PaymentParams();
	mPaymentParams.setKey(merchantKey);
	mPaymentParams.setAmount(amount);
	mPaymentParams.setProductInfo("phone_cover");
	mPaymentParams.setFirstName("firstname");
	mPaymentParams.setEmail(email);

	mPaymentParams.setTxnId("" + System.currentTimeMillis());

	mPaymentParams.setSurl("https://payu.herokuapp.com/success");
	mPaymentParams.setFurl("https://payu.herokuapp.com/failure");


	mPaymentParams.setUdf1("edf1");
	mPaymentParams.setUdf2("udf2");
	mPaymentParams.setUdf3("udf3");
	mPaymentParams.setUdf4("udf4");
	mPaymentParams.setUdf5("udf5");

	mPaymentParams.setUserCredentials(userCredentials);

	payuconfig.setEnvironment(environment);
	generateHashFromServer(mPaymentParams);


    }

    private void generateHashFromServer(PaymentParams mPaymentParams) {

    }

}


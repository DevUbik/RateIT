package com.pregatit.rateit;

import android.Manifest;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.normal.TedPermission;

import java.util.List;

public class SettingsPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel("Notifications","Notifications", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        Switch soundSwitch = (Switch) findViewById(R.id.soundSwitch);
        SharedPreferences shared = this.getSharedPreferences("RateIt", Context.MODE_PRIVATE);
        soundSwitch.setChecked(shared.getBoolean("valueS",true));

        Switch locationSwitch = (Switch) findViewById(R.id.locationSwitch);
        SharedPreferences preferences = this.getSharedPreferences("RateIt",Context.MODE_PRIVATE);
        locationSwitch.setChecked(preferences.getBoolean("valueL",false));

        Switch notificationsSwitch = (Switch) findViewById(R.id.notificationsSwitch);
        SharedPreferences preferencesNotif = this.getSharedPreferences("RateIt",Context.MODE_PRIVATE);
        notificationsSwitch.setChecked(preferencesNotif.getBoolean("valueN",false));

//        TextView editProfile = (TextView) findViewById(R.id.edit_profileText);
//        editProfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(view.getContext(), "Edit Profile",Toast.LENGTH_LONG).show();
//            }
//        });

        TextView connectedAccounts = (TextView) findViewById(R.id.connected_accountsText);
        connectedAccounts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "To be added later...",Toast.LENGTH_LONG).show();
            }
        });

        //dropdown pentru language
        String[] lg = getResources().getStringArray(R.array.languages);
        ArrayAdapter<String> arrayAdapterLg = new ArrayAdapter<String>(this,R.layout.dropdown,lg);
        AutoCompleteTextView autoCompleteTextViewLg = findViewById(R.id.autoCompleteTextLanguage);
        autoCompleteTextViewLg.setAdapter(arrayAdapterLg);

        //dropdown pentru theme
        String[] th = getResources().getStringArray(R.array.themes);
        ArrayAdapter<String> arrayAdapterTh = new ArrayAdapter<String>(this,R.layout.dropdown,th);
        AutoCompleteTextView autoCompleteTextViewTh = findViewById(R.id.autoCompleteTextTheme);
        autoCompleteTextViewTh.setAdapter(arrayAdapterTh);

    }

    public void OnImageButtonClick(View v)
    {
        Intent i = new Intent(this, MainMenuActivity.class);
        startActivity(i);
    }

    public void OnEditProfileClick(View v)
    {
        Intent i = new Intent(this, ProfilePageActivity.class);
        startActivity(i);
    }

    public void OnChangePasswordClick(View v)
    {
        Intent i = new Intent(this, CreateAccountActivity.class);

        i.putExtra("Sender",true);
        i.putExtra("ValueP","New password");
        i.putExtra("ValuePT","enter new password");
        i.putExtra("ValueB","Save changes");

        startActivity(i);

    }

//    public void OnPrivacyClick(View v)
//    {
//        TextView privacy = (TextView) findViewById(R.id.textView10);
//        privacy.setText("<h1>Privacy policy</h1>\n" +
//                "<p>We respect your privacy and are committed to protecting it through our compliance with this privacy policy (“Policy”). This Policy describes the types of information we may collect from you or that you may provide (“Personal Information”) in the “RateIT” mobile application (“Mobile Application” or “Service”) and any of its related products and services (collectively, “Services”), and our practices for collecting, using, maintaining, protecting, and disclosing that Personal Information. It also describes the choices available to you regarding our use of your Personal Information and how you can access and update it.</p>\n" +
//                "<p>This Policy is a legally binding agreement between you (“User”, “you” or “your”) and this Mobile Application developer (“Operator”, “we”, “us” or “our”). If you are entering into this agreement on behalf of a business or other legal entity, you represent that you have the authority to bind such entity to this agreement, in which case the terms “User”, “you” or “your” shall refer to such entity. If you do not have such authority, or if you do not agree with the terms of this agreement, you must not accept this agreement and may not access and use the Mobile Application and Services. By accessing and using the Mobile Application and Services, you acknowledge that you have read, understood, and agree to be bound by the terms of this Policy. This Policy does not apply to the practices of companies that we do not own or control, or to individuals that we do not employ or manage.</p>\n" +
//                "<h2>Collection of personal information</h2>\n" +
//                "<p>You can access and use the Mobile Application and Services without telling us who you are or revealing any information by which someone could identify you as a specific, identifiable individual. If, however, you wish to use some of the features offered in the Mobile Application, you may be asked to provide certain Personal Information (for example, your name and e-mail address).</p>\n" +
//                "<p>We receive and store any information you knowingly provide to us when you create an account, publish content,  or fill any forms in the Mobile Application. When required, this information may include the following:</p>\n" +
//                "<ul>\n" +
//                "<li>Account details (such as user name, unique user ID, password, etc)</li>\n" +
//                "<li>Geolocation data of your device (such as latitude and longitude)</li>\n" +
//                "<li>Certain features on the mobile device (such as contacts, calendar, gallery, etc)</li>\n" +
//                "</ul>\n" +
//                "<p>You can choose not to provide us with your Personal Information, but then you may not be able to take advantage of some of the features in the Mobile Application. Users who are uncertain about what information is mandatory are welcome to contact us.</p>\n" +
//                "<h2>Privacy of children</h2>\n" +
//                "<p>We do not knowingly collect any Personal Information from children under the age of 13. If you are under the age of 13, please do not submit any Personal Information through the Mobile Application and Services. If you have reason to believe that a child under the age of 13 has provided Personal Information to us through the Mobile Application and Services, please contact us to request that we delete that child’s Personal Information from our Services.</p>\n" +
//                "<p>We encourage parents and legal guardians to monitor their children’s Internet usage and to help enforce this Policy by instructing their children never to provide Personal Information through the Mobile Application and Services without their permission. We also ask that all parents and legal guardians overseeing the care of children take the necessary precautions to ensure that their children are instructed to never give out Personal Information when online without their permission.</p>\n" +
//                "<h2>Use and processing of collected information</h2>\n" +
//                "<p>We act as a data controller and a data processor when handling Personal Information, unless we have entered into a data processing agreement with you in which case you would be the data controller and we would be the data processor.</p>\n" +
//                "<p> Our role may also differ depending on the specific situation involving Personal Information. We act in the capacity of a data controller when we ask you to submit your Personal Information that is necessary to ensure your access and use of the Mobile Application and Services. In such instances, we are a data controller because we determine the purposes and means of the processing of Personal Information.</p>\n" +
//                "<p>We act in the capacity of a data processor in situations when you submit Personal Information through the Mobile Application and Services. We do not own, control, or make decisions about the submitted Personal Information, and such Personal Information is processed only in accordance with your instructions. In such instances, the User providing Personal Information acts as a data controller.</p>\n" +
//                "<p>In order to make the Mobile Application and Services available to you, or to meet a legal obligation, we may need to collect and use certain Personal Information. If you do not provide the information that we request, we may not be able to provide you with the requested products or services. Any of the information we collect from you may be used for the following purposes:</p>\n" +
//                "<ul>\n" +
//                "<li>Create and manage user accounts</li>\n" +
//                "<li>Run and operate the Mobile Application and Services</li>\n" +
//                "</ul>\n" +
//                "<p>Processing your Personal Information depends on how you interact with the Mobile Application and Services, where you are located in the world and if one of the following applies: (i) you have given your consent for one or more specific purposes; (ii) provision of information is necessary for the performance of an agreement with you and/or for any pre-contractual obligations thereof; (iii) processing is necessary for compliance with a legal obligation to which you are subject; (iv) processing is related to a task that is carried out in the public interest or in the exercise of official authority vested in us; (v) processing is necessary for the purposes of the legitimate interests pursued by us or by a third party.</p>\n" +
//                "<p> Note that under some legislations we may be allowed to process information until you object to such processing by opting out, without having to rely on consent or any other of the legal bases. In any case, we will be happy to clarify the specific legal basis that applies to the processing, and in particular whether the provision of Personal Information is a statutory or contractual requirement, or a requirement necessary to enter into a contract.</p>\n" +
//                "<h2>Managing information</h2>\n" +
//                "<p>You are able to delete certain Personal Information we have about you. The Personal Information you can delete may change as the Mobile Application and Services change. When you delete Personal Information, however, we may maintain a copy of the unrevised Personal Information in our records for the duration necessary to comply with our obligations to our affiliates and partners, and for the purposes described below. If you would like to delete your Personal Information or permanently delete your account, you can do so on the settings page of your account in the Mobile Application.</p>\n" +
//                "<h2>Disclosure of information</h2>\n" +
//                "<p> To maintain the highest level of privacy and to protect your Personal Information to the full extent, we do not share your Personal Information with anyone and for any reason.</p>\n" +
//                "<h2>Retention of information</h2>\n" +
//                "<p>We will retain and use your Personal Information for the period necessary as long as your user account remains active, to enforce our agreements, resolve disputes, and unless a longer retention period is required or permitted by law.</p>\n" +
//                "<p>We may use any aggregated data derived from or incorporating your Personal Information after you update or delete it, but not in a manner that would identify you personally. Once the retention period expires, Personal Information shall be deleted. Therefore, the right to access, the right to erasure, the right to rectification, and the right to data portability cannot be enforced after the expiration of the retention period.</p>\n" +
//                "<h2>Links to other resources</h2>\n" +
//                "<p>The Mobile Application and Services contain links to other resources that are not owned or controlled by us. Please be aware that we are not responsible for the privacy practices of such other resources or third parties. We encourage you to be aware when you leave the Mobile Application and Services and to read the privacy statements of each and every resource that may collect Personal Information.</p>\n" +
//                "<h2>Information security</h2>\n" +
//                "<p>We secure information you provide on computer servers in a controlled, secure environment, protected from unauthorized access, use, or disclosure. We maintain reasonable administrative, technical, and physical safeguards in an effort to protect against unauthorized access, use, modification, and disclosure of Personal Information in our control and custody. However, no data transmission over the Internet or wireless network can be guaranteed.</p>\n" +
//                "<p>Therefore, while we strive to protect your Personal Information, you acknowledge that (i) there are security and privacy limitations of the Internet which are beyond our control; (ii) the security, integrity, and privacy of any and all information and data exchanged between you and the Mobile Application and Services cannot be guaranteed; and (iii) any such information and data may be viewed or tampered with in transit by a third party, despite best efforts.</p>\n" +
//                "<p>As the security of Personal Information depends in part on the security of the device you use to communicate with us and the security you use to protect your credentials, please take appropriate measures to protect this information.</p>\n" +
//                "<h2>Data breach</h2>\n" +
//                "<p>In the event we become aware that the security of the Mobile Application and Services has been compromised or Users’ Personal Information has been disclosed to unrelated third parties as a result of external activity, including, but not limited to, security attacks or fraud, we reserve the right to take reasonably appropriate measures, including, but not limited to, investigation and reporting, as well as notification to and cooperation with law enforcement authorities. In the event of a data breach, we will make reasonable efforts to notify affected individuals if we believe that there is a reasonable risk of harm to the User as a result of the breach or if notice is otherwise required by law. When we do, we will post a notice in the Mobile Application, send you an email.</p>\n" +
//                "<h2>Changes and amendments</h2>\n" +
//                "<p>We reserve the right to modify this Policy or its terms related to the Mobile Application and Services at any time at our discretion. When we do, we will revise the updated date at the bottom of this page, send you an email to notify you. We may also provide notice to you in other ways at our discretion, such as through the contact information you have provided.</p>\n" +
//                "<p>An updated version of this Policy will be effective immediately upon the posting of the revised Policy unless otherwise specified. Your continued use of the Mobile Application and Services after the effective date of the revised Policy (or such other act specified at that time) will constitute your consent to those changes. However, we will not, without your consent, use your Personal Information in a manner materially different than what was stated at the time your Personal Information was collected.</p>\n" +
//                "<h2>Acceptance of this policy</h2>\n" +
//                "<p>You acknowledge that you have read this Policy and agree to all its terms and conditions. By accessing and using the Mobile Application and Services and submitting your information you agree to be bound by this Policy. If you do not agree to abide by the terms of this Policy, you are not authorized to access or use the Mobile Application and Services. This privacy policy was created with the <a target=\"_blank\" href=\"https://www.websitepolicies.com/privacy-policy-generator\" rel=\"noopener\">privacy policy generator</a>.</p>\n" +
//                "<h2>Contacting us</h2>\n" +
//                "<p>If you have any questions, concerns, or complaints regarding this Policy, the information we hold about you, or if you wish to exercise your rights, we encourage you to contact us using the details below:</p>\n" +
//                "<p><a target=\"_blank\" rel=\"nofollow\" href=\"http://www.rateIT.com/contact\">http://www.rateIT.com/contact/</a><br/>s&#117;pport&#64;&#114;a&#116;&#101;&#73;T.&#99;&#111;&#109;</p>\n" +
//                "<p>We will attempt to resolve complaints and disputes and make every reasonable effort to honor your wish to exercise your rights as quickly as possible and in any event, within the timescales provided by applicable data protection laws.</p>\n" +
//                "<p>This document was last updated on May 14, 2022</p>");
//    }

    public void OnSoundSwitchClick(View v)
    {
        Switch soundSwitch = (Switch) findViewById(R.id.soundSwitch);

        SharedPreferences shared = this.getSharedPreferences("RateIt", Context.MODE_PRIVATE);

        //soundSwitch.setChecked(shared.getBoolean("valueS",true));

        SharedPreferences.Editor editor = shared.edit();
        editor.putBoolean("valueS",soundSwitch.isChecked());
        editor.apply();
    }

    public void getLocation()
    {
        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(SettingsPageActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(SettingsPageActivity.this, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }

        };

        TedPermission.create()
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
                .check();

    }

    public void OnLocationSwitchClick(View v)
    {
        Switch location = (Switch) findViewById(R.id.locationSwitch);
        SharedPreferences shared = this.getSharedPreferences("RateIt", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        location.setChecked(shared.getBoolean("valueL",true));
        getLocation();
        if(ActivityCompat.checkSelfPermission(SettingsPageActivity.this,Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED)
        {
            editor.putBoolean("valueL",true);
            editor.apply();
            location.setChecked(true);
        }
        else
        {
            ActivityCompat.requestPermissions(SettingsPageActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 23);
            editor.putBoolean("valueL",false);
            editor.apply();
            location.setChecked(false);
        }

    }

    public void OnNotificationsSwitchClick(View v)
    {
        Switch notifications = (Switch) findViewById(R.id.notificationsSwitch);
        SharedPreferences shared = this.getSharedPreferences("RateIt", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        editor.putBoolean("valueN",notifications.isChecked());
        editor.apply();

        if(notifications.isChecked())
        {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(SettingsPageActivity.this,"Notifications");
            builder.setContentTitle("RateIT");
            builder.setContentText("From now on you will receive notifications from our app!");
            builder.setSmallIcon(R.mipmap.ic_rateit_foreground);
            builder.setAutoCancel(true);

            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(SettingsPageActivity.this);
            managerCompat.notify(1,builder.build());
        }
    }

    public void OnDeleteAccountClick(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(SettingsPageActivity.this);
        builder.setMessage("Do you want to permanently delete this account?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(SettingsPageActivity.this, "Account deleted!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SettingsPageActivity.this,LoginPageActivity.class);
                        startActivity(intent);
                    }
                }).setNegativeButton("Cancel",null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
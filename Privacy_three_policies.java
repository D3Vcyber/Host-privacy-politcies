package com.ai.genie;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ai.genie.ui.authentication.adapter.Cancellation_click;
import com.ai.genie.ui.authentication.adapter.Privacy_click;
import com.ai.genie.ui.authentication.adapter.Terms_click;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;

import com.ai.genie.api.API;
import android.content.Intent;

public class Privacy_three_policies extends AppCompatActivity {
     public TextView priv;
     public TextView terms;
     public TextView canc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_privacy_three_policies);
        priv=findViewById(R.id.privacy_payment_gateway);
        priv.setOnClickListener(view-> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(API.POLICY_URL));
            startActivity(intent);
        });
        terms=findViewById(R.id.data_privacy_policy);
        terms.setOnClickListener(view-> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(API.DATAPRIVACY_POLICY_URL));
            startActivity(intent);
        });

        canc=findViewById(R.id.cancellation_payment_gateway);
        canc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1=new Intent(Privacy_three_policies.this, Cancellation_click.class);
                        startActivity(int1);
                finish();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
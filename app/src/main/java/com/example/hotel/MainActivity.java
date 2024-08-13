package com.example.hotel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private CheckBox cbItem1, cbItem2, cbItem3, cbItem4;
    private TextView tvTotal, tvDiscount, tvFinalTotal;
    private Button btnCalculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbItem1 = findViewById(R.id.cb_item1);
        cbItem2 = findViewById(R.id.cb_item2);
        cbItem3 = findViewById(R.id.cb_item3);
        cbItem4 = findViewById(R.id.cb_item4);

        tvTotal = findViewById(R.id.tv_total);
        tvDiscount = findViewById(R.id.tv_discount);
        tvFinalTotal = findViewById(R.id.tv_final_total);

        btnCalculate = findViewById(R.id.btn_calculate);

        btnCalculate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                calculateBill();
            }
        });
    }


    private void calculateBill()
    {
        int totalAmount = 0;

        if (cbItem1.isChecked())
        {
            totalAmount += 5;
        }
        if (cbItem2.isChecked())
        {
            totalAmount += 8;
        }
        if (cbItem3.isChecked())
        {
            totalAmount += 7;
        }
        if (cbItem4.isChecked())
        {
            totalAmount += 4;
        }

        int discount = 0;
        if (totalAmount > 20)
        {
            discount = totalAmount * 10 / 100; // 10% discount for total amount greater than $20
        }

        int finalAmount = totalAmount - discount;

        tvTotal.setText("Total Amount: $" + totalAmount);
        tvDiscount.setText("Discount: $" + discount);
        tvFinalTotal.setText("Final Amount: $" + finalAmount);
    }
}


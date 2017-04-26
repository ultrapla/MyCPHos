package cph.nakhundee.wannapa.mycphos;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Meeting on 26/4/2560.
 */

public class MyAlert {
    private Context context;

    public MyAlert(Context context) {
        this.context = context;
    } // main method หลัก

    public  void  myDialog(String strTitle, String strMessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setIcon(R.mipmap.ic_user);   //สร้าง icon
        builder.setTitle(strTitle);          // สร้าง title
        builder.setMessage(strMessage);      // สร้าง Message
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });         //สร้าง Button  OK คือ ชื่อในปุ่ม
        builder.show();

    } // method ลอง ทำงานแจ้งเตือน
} // main class

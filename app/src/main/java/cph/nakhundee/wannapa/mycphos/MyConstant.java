package cph.nakhundee.wannapa.mycphos;



/**
 * Created by Meeting on 28/4/2560.
 */

public class MyConstant {

    private String urlGetProductWhere = "http://swiftcodingthai.com/cph/getProductWhereQRwannapa.php";

    private String[] columnProduct = new String[]{"id", "Name", "QR_code", "id_Receive", "Description", "Date_Receive"};

    private String urlGetUserWhereID = "http://swiftcodingthai.com/cph/getUserWhereID.php";

    public String getUrlGetUserWhereID() {
        return urlGetUserWhereID;
    }

    public String[] getColumnProduct() {   // สร้างขึ้นเพื่อนำไปใช้
        return columnProduct;
    }

    // สรา้ง method  alt+Enter
    public String getUrlGetProductWhere() {
        return urlGetProductWhere;
    }
} // main class

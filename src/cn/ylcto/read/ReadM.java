package cn.ylcto.read;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import cn.ylcto.book.vo.Doctor;
import cn.ylcto.book.vo.Medicine;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ReadM {
    String Cid;
    String name;
    String gender;
    String birthday;
    String tel;
    String duty;
    String photo;
    private static POIFSFileSystem fs;//poi文件流
    private static HSSFWorkbook wb;//获得execl
    private static HSSFRow row;//获得行
    private static HSSFSheet sheet;//获得工作簿
    private Medicine medicine;
    private List<Medicine> list;

    public List<Medicine> imports(InputStream in) {
        try {
            fs = new POIFSFileSystem(in);
            wb = new HSSFWorkbook(fs);
            sheet = wb.getSheetAt(0);
            int rowend = sheet.getLastRowNum();
            list=new ArrayList<Medicine>();
            for (int i = 1; i <= rowend; i++) {
                medicine=new Medicine();
                row = sheet.getRow(i);
                //  int colNum = row.getPhysicalNumberOfCells();//一行总列数
                medicine.setId(getCellFormatValue(row.getCell(0)));
                medicine.setName(getCellFormatValue(row.getCell(1)));
                medicine.setPrice(getCellFormatValue(row.getCell(2)));
                medicine.setAmount(getCellFormatValue(row.getCell(3)));
                list.add(medicine);

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }


    private String getCellFormatValue(HSSFCell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
                // 如果当前Cell的Type为NUMERIC
                case HSSFCell.CELL_TYPE_NUMERIC:
                case HSSFCell.CELL_TYPE_FORMULA: {
                    // 判断当前的cell是否为Date
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        cellvalue = sdf.format(date);
                    }
                    // 如果是纯数字
                    else {
                        // 取得当前Cell的数值
                        DecimalFormat df = new DecimalFormat("#");//转换文本格式
                        cellvalue = String.valueOf(df.format(cell.getNumericCellValue()));
                    }
                    break;
                }
                // 如果当前Cell的Type为STRIN
                case HSSFCell.CELL_TYPE_STRING:
                    // 取得当前的Cell字符串
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                // 默认的Cell值
                default:
                    cellvalue = " ";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;
    }
}




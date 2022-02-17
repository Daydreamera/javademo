package basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DateTools {
    public static String getNow(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String nowStr = sdf.format(now);
        return nowStr;
    }

    public static int getnDaysOfTwoDate(String dateOneString, String dateTwoString) throws ParseException {
        /**
         * 获取两个日期的间隔天数
         * @param dateOneString
         * @param dateTwoString
         * @return int
         * @creed: Talk is cheap,show me the code
         * @date 2021/9/14 16:12
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date dateOne = sdf.parse(dateOneString);
        Date dateTwo = sdf.parse(dateTwoString);
        if (dateOne.compareTo(dateTwo) == 0) {
            return 0;
        } else if (dateOne.compareTo(dateTwo) == -1) {
            long diff = dateTwo.getTime() - dateOne.getTime();
            int days = (int) (diff / (1000 * 60 * 60 * 24));
            return days;
        } else {
            long diff = dateOne.getTime() - dateTwo.getTime();
            int days = (int) (diff / (1000 * 60 * 60 * 24));
            return days;
        }
    }

    public static String getnDaysBefore(int n) {
        /**
         * 获取n天前的日期
         * @param n
         * @return String
         * @creed: Talk is cheap,show me the code
         * @date 2021/9/14 16:02
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.DAY_OF_YEAR, -n);
        Date nDaysBefore = calendar.getTime();
        return sdf.format(nDaysBefore);
    }

    public static ArrayList<String> getListOfTwoDate(String beginDateString, String endDateString) throws ParseException {
        /**
         * 获取两个日期范围内的所有日期
         * @param dateOneString
         * @param dateTwoString
         * @return java.util.Date[]
         * @creed: Talk is cheap,show me the code
         * @date 2021/9/15 13:53
         */

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        ArrayList<String> dates = new ArrayList<String>();
        Date beginDate = sdf.parse(beginDateString.replace("-", ""));
        Date endDate = sdf.parse(endDateString.replace("-", ""));
        Date tempDate = beginDate;
        while (tempDate.compareTo(endDate) <= 0) {
            dates.add(sdf.format(tempDate));
            calendar.setTime(tempDate);
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            tempDate = calendar.getTime();
        }
        return dates;
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(getnDaysBefore(652));
        System.out.println(getnDaysOfTwoDate("2021-09-14", "2020-05-26"));
//        System.out.println(getNow());
}
    }

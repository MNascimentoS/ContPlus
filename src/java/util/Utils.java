package util;

/**
 *
 * @author mateus
 */
public class Utils {
    public static String getFormatedData(String data) {
        String newData = "";
        
        String[] parts = data.split(" ");
        String[] parts2 = parts[1].split(",");
        if (Integer.valueOf(parts[0]) < 10) newData += "0"; 
        newData += parts[0] + "/";
        switch (parts2[0]) {
            case "Janeiro": newData += "01/";
                break;
            case "Fevereiro": newData += "02/";
                break;
            case "Março": newData += "03/";
                break;
            case "Abril": newData += "04/";
                break;
            case "Maio": newData += "05/";
                break;
            case "Junho": newData += "06/";
                break;
            case "Julho": newData += "07/";
                break;
            case "Agosto": newData += "08/";
                break;
            case "Setembro": newData += "09/";
                break;
            case "Outubro": newData += "10/";
                break;
            case "Novembro": newData += "11/";
                break;
            case "Dezembro": newData += "12/";
                break;
        }
        newData += parts[2];
        return newData;
    }
    
    public static String getData(String data) {
        String newData = "";
        
        String part1 = data.substring(0, Math.min(2,data.length()));
        newData += part1 + "/";
        String part2 = data.substring(2, data.length() - 4);
        System.out.println(part2);
        switch (part2) {
            case "Janeiro": newData += "01/";
                break;
            case "Fevereiro": newData += "02/";
                break;
            case "Março": newData += "03/";
                break;
            case "Abril": newData += "04/";
                break;
            case "Maio": newData += "05/";
                break;
            case "Junho": newData += "06/";
                break;
            case "Julho": newData += "07/";
                break;
            case "Agosto": newData += "08/";
                break;
            case "Setembro": newData += "09/";
                break;
            case "Outubro": newData += "10/";
                break;
            case "Novembro": newData += "11/";
                break;
            case "Dezembro": newData += "12/";
                break;
        }
        String part3 = data.substring(data.length() - 4, data.length());
        newData += part3;
        System.out.println(newData);
        return newData;
    }
}

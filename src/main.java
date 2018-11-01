import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Tarun Narayanan on 30.10.2018
 *
 * This class sorts the Kings with roman's numbers by their names.
 * Special Constraint: In case two or more kings have the same name, the Kings will be sorted by the value of the roman number.
 */
public class main {

    public static void main(String[] args){

        ArrayList <King> orderKings = new ArrayList<King>();
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        int n;

        System.out.print("Enter number of Kings: ");
        try {
            n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                String name = br.readLine();
                String[] arr = name.split("\\s");

                orderKings.add(new King(arr[0], arr[1]));
            }

//        King philipII = new King("Philip", "II");
//        King charlesI = new King("Charles", "I");
//        King alfonsoXIII = new King("Alfonso", "XIII");
//        King fernandoXIV = new King("Fernando", "XIV");
//        King fernandoXXIV = new King("Fernando", "XXIV");
//        King philipIV = new King("Philip", "IV");
//
//        orderKings.add(philipII);
//        orderKings.add(charlesI);
//        orderKings.add(alfonsoXIII);
//        orderKings.add(fernandoXIV);
//        orderKings.add(fernandoXXIV);
//        orderKings.add(philipIV);

            Collections.sort(orderKings);

            for (King king : orderKings) {
                System.out.println(king.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

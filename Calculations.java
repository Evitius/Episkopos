public class Calculations {



    void sinus(double stopnieInput, int dlugoscSzeregu) {

        boolean dodatnie=true;
        double stopniePoPrzeksztalceniu;

        //przekształcenia kątów
        if (stopnieInput >270)
        {
            stopniePoPrzeksztalceniu = 360 - stopnieInput;
            dodatnie = !dodatnie;
        }
        else if(stopnieInput > 180)
            stopniePoPrzeksztalceniu = 180 - stopnieInput;
        else if (stopnieInput >90)
        {
            stopniePoPrzeksztalceniu = stopnieInput - 180;
            dodatnie = !dodatnie;
        }
        else stopniePoPrzeksztalceniu=stopnieInput;

        //konwersja na radiany
        double radiany= ((stopniePoPrzeksztalceniu * Math.PI)/180);

        double wynik=0.0;
        int wyrazSzeregu = 1;

        while(wyrazSzeregu<=dlugoscSzeregu){

            if (dodatnie) wynik += Math.pow(radiany, wyrazSzeregu) / silnia(wyrazSzeregu);
            else wynik -= Math.pow(radiany, wyrazSzeregu) / silnia(wyrazSzeregu);
            dodatnie = !dodatnie;
            System.out.println("wyraz " + wyrazSzeregu  + " : " + wynik);
            wyrazSzeregu += 2;
        }

        double biblioteka = Math.sin(radiany);
        double roznica;

        if(dodatnie)
        roznica= wynik + biblioteka;
        else roznica= wynik-biblioteka;



        System.out.print("Sinus z " + stopnieInput + " o rozwinięciu " + dlugoscSzeregu + " wynosi " + wynik  + " Biblioteka: " + biblioteka+ " roznica "  +  roznica );
        System.out.println(" ");
    }


    public int silnia(int i) {

        if (i == 0)
            return 1;
        else
            return i * silnia(i - 1);

    }


    public static void main(String[] args){
       Calculations calc= new Calculations();

       calc.sinus(10, 10);
       calc.sinus(350, 10);
       calc.sinus(270, 10);
       calc.sinus(240, 10);
       calc.sinus(320, 10);
       calc.sinus(190, 10);
       calc.sinus(90, 10);

    }
}
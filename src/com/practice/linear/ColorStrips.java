package linear;


 /*Input = S - 2,W - 5, G -3
  Output = SWSWGWGWGW
  S - 1,W - 15, G -3
*/


public class ColorStrips {


    public boolean isflagPossible(int saffron, int white, int green) {
        int sets = 0;

        int strip = greatestStrip(saffron,white,green);

       for(int index = strip; index <=0; index--) {
           if(saffron > 0 && green > 0) {
               saffron--;
           }

           if(green > 0) {
               green --;
           }

           if(white > 0) {
               white --;
           }

           sets++;


       }

        return false;
    }

    private int greatestStrip(int saffron, int white, int green) {
        if(saffron >= white) {
            if(saffron>=green) {
                return saffron;
            } else {
                return green;
            }
        } else {
            return white;
        }

    }

    public boolean isColorEmpty (int color) {
        if(color==0) {
            return true;
        }
        return false;
    }
    public static void main(String [] args) {

    }
}

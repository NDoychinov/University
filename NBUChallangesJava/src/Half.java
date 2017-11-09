import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class Half {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String read = reader.readLine();


        while (!read.equals("")) {
            String[] firstLine = read.split("\\s+");
            int size = Integer.parseInt(firstLine[0]);
            int iterations = Integer.parseInt(firstLine[1]);
            String[] secondLine = reader.readLine().split("\\s+");


            LinkedList<Fraction> nums = new LinkedList<>();
            for (String aLine : secondLine) {
                Fraction currentNum = new Fraction(Integer.parseInt(aLine));
                nums.add(currentNum);
            }

            Fraction largestNum;
            for (int j = 0; j < iterations; j++) {
                largestNum = nums.get(0);
                int largestIndex = 0;
                for (int i = 1; i < nums.size(); i++) {
                    if (Fraction.compareTwo(nums.get(i), largestNum)) {
                        largestNum = nums.get(i);
                        largestIndex = i;
                    }
                }

                nums.remove(largestIndex);
                largestNum.divideBy(2);
                nums.add(largestNum);
                nums.add(largestNum);
            }

            largestNum = nums.get(0);
            for (int i = 1; i < nums.size(); i++) {
                if (Fraction.compareTwo(nums.get(i), largestNum)) {
                    largestNum = nums.get(i);
                }
            }
            System.out.println(largestNum.toString());

            read = reader.readLine();
        }
    }
}


class Fraction {
    private long upperPart;
    private long downPart;

    public Fraction(long upperPart) {
        this.setUpperPart(upperPart);
        this.setDownPart(1);
    }

    public Fraction(long upperPart, long secondPart) {
        this.setUpperPart(upperPart);
        this.setDownPart(secondPart);
    }

    public long getUpperPart() {
        return upperPart;
    }

    public void setUpperPart(long upperPart) {
        this.upperPart = upperPart;
    }

    public long getDownPart() {
        return downPart;
    }

    public void setDownPart(long downPart) {
        this.downPart = downPart;
    }

    public void divideBy(long num){
        this.downPart *= num;
        this.reduceFraction();
    }

    private void reduceFraction() {
        long gcd = gcd(this.upperPart, this.downPart);
        this.downPart /= gcd;
        this.upperPart /= gcd;
    }

    public long gcd (long n, long m) {
        if (m > n) {
            if ((m % n) == 0)
                return n;
            else
                return gcd(n, m % n);
        }
        else {
            if ((n % m) == 0)
                return m;
            else
                return gcd(m, n % m);
        }
    }

    public static boolean compareTwo(Fraction first, Fraction second) {
        return first.getUpperPart() * second.getDownPart() > second.getUpperPart() * first.getDownPart();

    }

    @Override
    public String toString() {
        if (this.downPart == 1) {
            return String.valueOf(upperPart);
        }
        return String.format("%d/%d", upperPart, downPart);
    }
}





package ePortfolio;

public class MutualFund extends Investment { // initialize subclass mutual fund

   public MutualFund (String symbol, String name, int quantity, double price) throws Exception {

      super(symbol, name, quantity, price);

   }

   @Override

   public double calculateBookValue(int quantity, double price) {

      double bookValue = 0.0;

      bookValue = this.getBookValue() + (quantity * price);

      return bookValue;

   }

   @Override

   public String payment(int quantity, double price) { // to be overridden

      return ("Payment Recieved: $" + (quantity * price - 45.00) + "\n");

   }

   @Override

   public double getGain(int quantity, double price) { // to be overridden

      return (quantity * price - 45.00) - this.getBookValue();

   }

   @Override

   public String toWrite() {

      return ("type = " + "\"mutualfund\"" +
              "\nsymbol = " + "\"" + this.getSymbol() + "\"" +
              "\nname = " + "\"" + this.getName() + "\"" +
              "\nquantity = " + "\"" + this.getQuantity() + "\"" +
              "\nprice = " + "\"" + this.getPrice() + "\"" +
              "\nbookValue = " + "\"" + this.getBookValue()+ "\"" + "\n\n");

   }

}// end of mutualfund

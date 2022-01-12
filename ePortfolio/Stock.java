package ePortfolio;

public class Stock extends Investment { // initialize subclass stock

   public Stock (String symbol, String name, int quantity, double price) throws Exception{

         super(symbol, name, quantity, price);

   }

   @Override

   public double calculateBookValue(int quantity, double price) {

      double bookValue = 0.0;

      bookValue = this.getBookValue() + (quantity * price) + 9.99;

      return bookValue;

   }

   @Override

   public String payment(int quantity, double price) { // to be overridden

      return ("Payment Recieved: $" + (quantity * price - 9.99) + "\n");

   }

   @Override

   public double getGain(int quantity, double price) { // to be overridden

      return (quantity * price - 9.99) - this.getBookValue();

   }

   @Override

   public String toWrite() {

      return ("type = " + "\"stock\"" +
              "\nsymbol = " + "\"" + this.getSymbol() + "\"" +
              "\nname = " + "\"" + this.getName() + "\"" +
              "\nquantity = " + "\"" + this.getQuantity() + "\"" +
              "\nprice = " + "\"" + this.getPrice() + "\"" +
              "\nbookValue = " + "\"" + this.getBookValue()+ "\"" + "\n\n");

   }

}// end of stock

package ePortfolio;

abstract public class Investment { // initialize superclass investment with attributes

   private String symbol;
   private String name;
   private int quantity;
   private double price;
   private double bookValue;

   public Investment (String symbol, String name, int quantity, double price) throws Exception {

      if (symbol.isEmpty() || name.isEmpty()) {

         throw new Exception ("\nError: Parameters are invalid. Please provide all investment information. \n");

      }

      if (quantity < 0) {

         throw new Exception ("Error: Price is invalid. \n");

      }

      if (price < 0) {

         throw new Exception ("Error: Quantity is invalid. \n");

      }

      this.setSymbol(symbol);
      this.setName(name);
      this.setQuantity(quantity);
      this.setPrice(price);

   }

   public void setSymbol (String symbol) {
         this.symbol = new String (symbol);
   }

   public void setName (String name) {
         this.name = new String (name);
   }

   public void setQuantity (int quantity) {
         int temp = quantity;
         this.quantity = temp;
   }

   public void setPrice (double price) {
         double temp = price;
         this.price = temp;
   }

   public void setBookValue (double bookValue) {

      double temp = bookValue;
      this.bookValue = temp;
   }

   public String getSymbol () {
      return new String(symbol);
   }

   public String getName () {
      return new String (name);
   }

   public int getQuantity () {
      int temp = quantity;
      return temp;
   }

   public double getPrice () {
      double temp = price;
      return temp;
   }

   public double getBookValue() {
      double temp = bookValue;
      return temp;
   }

   public String toString() { // used to print all attributes of an individual stock

      return ("\nSymbol: " + this.getSymbol() +
              "\nName: " + this.getName() +
              "\nQuantity: " + this.getQuantity() +
              "\nPrice: " + this.getPrice() +
              "\nbookValue: " + this.getBookValue() + "\n");

   }

   public boolean inRange(String priceRange) {

      int low = 0;
      int high = 0;
      String str = priceRange.replace("-"," ");
      str = str.trim();

      String prices[] = str.split("[ ]+");

      try { // convert str to ints with error checking

         if (prices.length == 1) {

            low = Integer.parseInt(prices[0]);

         } else if (prices.length == 2) {

            low = Integer.parseInt(prices[0]);
            high = Integer.parseInt(prices[1]);

         }

      } catch (NumberFormatException ex) {

      }

      if (priceRange.length() > 0) {

         if (priceRange.charAt(0) == '-') { // if the range is all values =/less than

            if (this.getPrice() <= low) {

               return true;

            }

         }

         if (priceRange.charAt(priceRange.length() - 1) == '-') { // if the range is all values =/ more than

            if (this.getPrice() >= low) {

               return true;

            }

         }

      }

      if (prices.length == 1) { // if there is one value and the prices are equal

         if (this.getPrice() == low) {

            return true;

         }

      }

      if (prices.length == 2) { // if the price is in range, between low and high

         if (this.getPrice() <= high) {

            if (this.getPrice() >= low) {

               return true;

            }

         }

      }

      return false;

   }

   abstract public double calculateBookValue(int quantity, double price);

   abstract public String toWrite();

   abstract public String payment(int quantity, double price);

   abstract public double getGain(int quantity, double price);

}// end of stock

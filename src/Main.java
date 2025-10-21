 class Main {
     public static void main(String[] args) {
        RecordStudio r = new RecordStudio("sT" , 23);
        RecordStudio r2 = new RecordStudio("VT" , 33);
         System.out.println(r.compareTo(r2));
         System.out.println(r.equals(r2));
     }
 }
public class Theater {
    private Seat[][] seats;
    private int total = 0;
    private int rowCount, colCount;

    public Theater(int rowCount, int colCount){
        if(rowCount > 26)
            rowCount = 26;
        seats = new Seat[rowCount][colCount];
        for(int i=0;i<rowCount;i++){
            for(int j=0;j<colCount;j++){
                seats[i][j] = new Seat();
            }
        }
        this.rowCount = rowCount;
        this.colCount = colCount;
    }
    public boolean reserve(String name, char rowChar, int col, int numSeat){
        if(getRowIndex(rowChar)>rowCount || col > colCount)
            return false;
        if((col+numSeat)>colCount+1)
            return false;
        for(int i=(col-1);i<(col+numSeat-1);i++){
            if(seats[getRowIndex(rowChar)][i].isOccupied())
                return false;
        }
        for(int i=(col-1);i<(col+numSeat-1);i++){
            seats[getRowIndex(rowChar)][i].reserve(name);
            total++;
        }
        return true;
    }
    public int cancel(String name){
        int cnt = 0;
        for(int i=0;i<rowCount;i++){
            for(int j=0;j<colCount;j++){
                if(seats[i][j].getName() == null)
                    continue;
                if(seats[i][j].match(name)){
                    seats[i][j].cancel();
                    cnt++;
                    total--;
                }
            }
        }
        return cnt;
    }
    public int getNumberOfReservedSeat(){
        return total;
    }

    public void printSeatMatrix(){
        System.out.println("----------------------------------------------------------");
        System.out.print("  ");
        for(int i=1;i<=16;i++){
            if(i == 5)
                System.out.print("   ");
            if(i == 13)
                System.out.print("   ");
            if(i>10)
                System.out.print(" "+i);
            else
                System.out.print("  "+i);
        }
        System.out.println();

        for(int i=0;i<rowCount;i++) {
            System.out.print((char) ('A' + i) + ": ");
            for (int j = 0; j < colCount; j++) {
                Seat s = seats[i][j];
                if(j == 4 || j == 12)
                    System.out.print("   ");
                if (s.isOccupied())
                    System.out.print("[O]");
                else
                    System.out.print("[ ]");
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------------------");
    }
    private int getRowIndex(char uppercaseChar){
        return uppercaseChar - 'A';
    }
}

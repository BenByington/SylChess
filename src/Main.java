class Main {
  public static void main(String[] args) {
    Board board = new Board();
    System.out.println(board.toString());
    System.out.println(board.isMoveValid(0,1,0,3)); //true
    System.out.println(board.isMoveValid(5,1,5,6)); //false
    System.out.println(board.isMoveValid(3,1,3,2)); //true
    System.out.println(board.isMoveValid(7,1,3,2)); //false
  }
}
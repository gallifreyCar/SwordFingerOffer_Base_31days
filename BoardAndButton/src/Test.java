public class Test {
    public static void main(String[] args) {
            Button button =new Button();

            BoardA boardA=new BoardA(button);
            boardA.getButton().click(boardA);

            BoardB boardB=new BoardB(button);
            boardB.onCLick();
    }
}

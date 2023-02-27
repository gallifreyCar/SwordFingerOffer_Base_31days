
interface ButtonListen {

   void clickHandle();
}


public class Button {

    public void click(ButtonListen buttonListen){

        new Thread(() -> {
            try {
                System.out.println("Button 被点击了");
                Thread.sleep(1000);
                buttonListen.clickHandle();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ).start();

    }



}

class BoardA implements ButtonListen {
    private Button button;

    @Override
    public void clickHandle() {
        System.out.println("A修改文本");
    }

    public BoardA(Button button) {
        this.button = button;
    }

    public Button getButton() {
        return button;
    }
}


class BoardB implements ButtonListen {
    private Button button;


    @Override
    public void clickHandle() {
        System.out.println("B修改了形状");
    }

    public BoardB(Button button) {
        this.button = button;
    }
    
    void  onCLick(){
        button.click(this);
        System.out.println("B继续工作");
}}

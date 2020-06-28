package annotation;

import java.awt.Color;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;


/*生成隨機數獨
 * 流程：
 * 1.生成9*9空白數獨數組
 * 2.隨機往數獨數組填數
 * 3.DFS生成數獨標準解（即數獨數組81個格子都填滿數字）
 * 4.先挖n個空，對挖完空的數獨進行求解（全部）
 * 5.將所有解與標準解進行對比，將不一樣的地方記錄下。這些地方不允許被被挖空
 */
class MakeSDK {
    private int[][] Arr;//臨時數組
    private int [][]Sudoku;
    private int [][]Answer;//答案
    private int [][]Game;

    public MakeSDK(){
        this.Arr=new int[9][9];
        this.Sudoku=new int[9][9];
        this.Answer=new int[9][9];
        rand();
        DFS(Arr,0,false);
        diger();
    }

    private void rand(){
        int t=0;
        int x,y,num;
        //先往數組裏面隨機丟t個數
        while(t<15){//t不宜多，否則運行起來耗費時間；t也不宜少，否則生成的遊戲看起來一點也不隨機
            x=new Random().nextInt(9);
            y=new Random().nextInt(9);
            num=new Random().nextInt(9)+1;
            if(Arr[y][x]==0){
                if(isTrue(Arr,x,y,num)==true){
                    Arr[y][x]=num;++t;
                }
            }
        }
    }

    //判斷該數字填寫的地方是否符合數獨規則
    private boolean isTrue(int arr[][],int x,int y,int num){//數字橫座標；數字縱座標；數字數值
        //判斷中單元格（3*3）
        for(int i=(y/3)*3;i<(y/3+1)*3;++i){
            for(int j=(x/3)*3;j<(x/3+1)*3;++j){
                if(arr[i][j]==num){return false;}
            }
        }
        //判斷橫豎
        for(int i=0;i<9;++i){
            if(arr[i][x]==num || arr[y][i]==num){return false;}
        }
        return true;
    }

    //深度優先搜索尋找
    //絕對有很多種解法，但是我們只需要第一個解出來的
    private boolean flag=false;//判斷是否得出一個解
    int total=0;
    private void DFS(int arr[][],int n,boolean all){//arr是數獨數組，n是探索深度（一共81個格子，深度爲81,n爲0~80），是否要求全部解
        //n/9爲格子的縱座標，n%9爲格子的橫座標
        if(n<81){
            //如果已經求出了一種解，終止遞歸就行了，不用繼續求下去了
            if(flag==true && all==false){return;}

            if(arr[n/9][n%9]==0){
                for(int i=1;i<10;++i){
                    if(isTrue(arr,n%9,n/9,i)==true){
                        arr[n/9][n%9]=i;
                        DFS(arr,n+1,all);
                        arr[n/9][n%9]=0;
                    }
                }
            }else{
                DFS(arr,n+1,all);
            }

        }else{
            if(all==false){
                flag=true;
                for(int i=0;i<9;++i){
                    for(int j=0;j<9;++j){
                        Sudoku[i][j]=arr[i][j];
                        Answer[i][j]=arr[i][j];
                    }
                }
            }else{
                ++total;
                System.out.println("\n解"+total);
                for(int i=0;i<9;++i){
                    for(int j=0;j<9;++j){
                        System.out.print(arr[i][j]);
                        if(arr[i][j]!=Answer[i][j]){
                            Game[i][j]=Answer[i][j];
                        }
                    }
                    System.out.println();
                }
                System.out.println("\n");
            }
        }
    }


    //給數獨挖空
    //保證僅有一解
    private void diger(){
        int t=45;
        Game=new int[9][9];
        while(t>0){
            int x=new Random().nextInt(9);
            int y=new Random().nextInt(9);
            if(Sudoku[y][x]!=0){
                Sudoku[y][x]=0;--t;
            }
        }

        for(int i=0;i<9;++i){
            for(int j=0;j<9;++j){
                Game[i][j]=Sudoku[i][j];
            }
        }

        DFS(Sudoku,0,true);
    }

    //獲取最終數獨
    public int[][] getArr(){
        return this.Game;
    }

    //獲取數獨答案
    public int[][] getAnswer(){
        return this.Answer;
    }
}


//遊戲界面
class UI{
    private JFrame GameUI;
    private JLabel BigGrid;//大格子（9*9）
    private JLabel MidGrid[];//中格子（3*3）
    private JLabel SmaGrid;//小格子（1*1）

    public UI(){
        GameUI=new JFrame();
        GameUI.setVisible(true);
        GameUI.setLayout(null);
        GameUI.setSize(400,330);

        //大格子
        BigGrid=new JLabel();
        BigGrid.setBorder(BorderFactory.createLineBorder(Color.black));
        BigGrid.setBounds(10,10,270,270);
        GameUI.add(BigGrid);

        MidGrid=new JLabel[9];
        int h=0;
        for(int i=0;i<3;++i){
            for(int j=0;j<3;++j){
                MidGrid[h]=new JLabel();
                MidGrid[h].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
                MidGrid[h].setBounds(i*90,j*90,90,90);
                BigGrid.add(MidGrid[h]);
                ++h;
            }
        }
    }
}

class Main {
    //測試方法
    public static void main(String arg[]){
        MakeSDK game=new MakeSDK();
        //new UI();
//		for(int i=0;i<9;++i){
//			if(i%3==0 && i!=0){
//				System.out.print("\n------------------------");
//			}
//			System.out.println();
//			for(int j=0;j<9;++j){
//				if(j%3==0){
//					System.out.print("| ");
//				}
//				System.out.print(game.getArr()[i][j]+" ");
//			}
//		}
        System.out.println("生成題目：");
        for(int i=0;i<9;++i){
            for(int h=0;h<9;++h){
                System.out.print(game.getArr()[i][h]);
            }
            System.out.println();
        }
    }
}

import java.util.Scanner;

//public class Node1 {
    class node {
        int data;
        node left;
        node right;
        boolean color;

        node (int data){
            this.data = data;
            left = null;
            right = null;
//Новый узел, который создается всегда имеет красный цвет.
            color = true;
        }
    }

    public class LLRBTREE{
        private static node root = null;
//Функция для поворота узла против часовой стрелки.
        node rotateLeft(node myNode){
            System.out.printf("поворот влево\n");
            node child = myNode.right;
            node childLeft = child.left;

            child.left = myNode;
            myNode.right = childLeft;

            return child;
        }
//Функция для поворота узла по часовой стрелки.
        node rotateRight(node myNode){
            System.out.printf("поворот вправо\n");
            node child = myNode.left;
            node childRight = child.right;

            child.right = myNode;
            myNode.left = childRight;

            return child;

        }
//Функция для проверки является ли узел красного цвета или нет.
        boolean isRed(node myNode){
            if(myNode == null){
                return false;
            }
            return (myNode.color == true);
        }
//Функция для изменения цвета двух узлов.
        void swapColors(node node1, node node2){
            boolean temp = node1.color;
            node1.color = node2.color;
            node2.color = temp;
        }

        node insert (node myNode, int data){
            if(myNode == null){
                return new node(data);
            }
            if(data < myNode.data){
              myNode.left = insert(myNode.left, data);
            } else if (data > myNode.data){
              myNode.right = insert(myNode.right, data);
            } else {
                return myNode;
            }

            if (isRed(myNode.right) && !isRed(myNode.left)) {
//Поворот узла в лево.
                myNode = rotateLeft(myNode);
                swapColors(myNode, myNode.left);

            }
//когда левый ребенок, а так же левый ребенок этого ребенка выделены красным цветом
            if (isRed(myNode.left) && !isRed(myNode.left.left)) {

                myNode = rotateRight(myNode);
                swapColors(myNode, myNode.right);
            }

            if (isRed(myNode.left) && isRed(myNode.right)) {
//инвертировать цвет узла это левый и правый дети.
                myNode.color = !myNode.color;
//изменить цвет для на черный.
                myNode.left.color = false;
                myNode.right.color = false;

            }
                return myNode;

        }

        void inorder(node node){
            if(node != null){
                inorder(node.left);
                char c = 'o';
                if (node.color == false)
                c = 'O';
                System.out.print(node.data + " " + c + " ");
                inorder(node.right);
            }

        }

        public static void main(String[] args) {
            LLRBTREE node = new LLRBTREE();
            Scanner scan = new Scanner (System.in);

            char ch;
            do {
                System.out.println("Введите целое число");
                int num = scan.nextInt();
                root = node.insert(root, num);

                node.inorder(root);
                System.out.println("\nВы хотите продолжить? (введите y или n)");
                ch = scan.next().charAt(0);
             
            } while (ch == 'Y' || ch == 'у');

        }
    }
//}

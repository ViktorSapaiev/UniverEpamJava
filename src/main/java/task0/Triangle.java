package task0;

public class Triangle implements ShowAble {
        private int edgeSize;

        Triangle(int edgeSize) {
            this.edgeSize = edgeSize;
        }

        public void draw() {
            int size = edgeSize;
            while (size > 0) {
                for (int i = 0; i < size - 1; i++) {
                    System.out.print(" ");
                }
                if (size == edgeSize) {
                    System.out.print("* ");
                } else if (size < edgeSize && size > 1) {
                    System.out.print("* ");
                    for (int i = 0; i < edgeSize - size - 1; i++) {
                        if (size != edgeSize - 1) {
                            System.out.print("  ");
                        }
                    }
                    System.out.print("* ");
                } else if (size == 1) {
                    for (int i = 0; i < edgeSize; i++) {
                        System.out.print("* ");
                    }
                }
                System.out.print("\n");
                size--;
            }
        }
}


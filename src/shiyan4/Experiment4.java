package shiyan4;

import java.util.Arrays;

public class Experiment4 {
    public static int[] block = {0, 0, 0};  // 内存块容量 0 表示空闲
    public static int[] pageOrder = {1, 5, 4, 2, 3, 5, 2, 3, 4, 4, 1, 3};  //页面需要使用顺序
    public static int  eliminatePage= 0;  // 缺页计数器
    public static void main(String[] args) {
        System.out.println("页码  内存块");
        for (int i = 0; i < pageOrder.length; i++) {
            System.out.println(" ");
            System.out.print(pageOrder[i]);  // 输出当前需要访问的页
            if (!isInBlock(pageOrder[i])) {
                int blockIdex = isBlockNull();
                if (blockIdex != -1) {
                    block[blockIdex] = pageOrder[i];
                    eliminatePage++;
                    System.out.print("\t"+Arrays.toString(block));
                    continue;
                }
                blockIdex = selectEliminateBlock(i);
                block[blockIdex] = pageOrder[i];
                eliminatePage++;
                System.out.print("\t"+Arrays.toString(block));
            }
        }
        System.out.println("\n缺页次数为："+eliminatePage+"\t缺页率为："+((double)eliminatePage/pageOrder.length));
    }

    // 查询内存块是否为空
    public static int isBlockNull() {
        for (int i = 0; i < block.length; i++) {
            if (block[i] == 0)
                return i;
        }
        return -1;
    }

    // 判断内存块中是否有当前需要读取的页
    public static boolean isInBlock(int page) {
        for (int item : block) {
            if (item == page)
                return true;
        }
        return false;
    }

    // 查询将淘汰的页码的索引
    public static int selectEliminateBlock(int index) {
        int[] retainPage = {0, 0};
        for (int i = 0; i < block.length - 1; i++)
            retainPage[i] = pageOrder[index - i - 1];
        for (int i = 0; i < block.length; i++) {
            if (retainPage[0] != block[i] && retainPage[1] != block[i])
                return i;
        }
        return -1;
    }
}

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Project name(项目名称)：算法_折半查找
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/13
 * Time(创建时间)： 20:50
 * Version(版本): 1.0
 * Description(描述)：
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 T ，写一个函数搜索 nums 中的 T，如果目标值存在返回下标，否则返回 -1。
 * 样例 1:
 * 测试输入: n = 6 ，nums = [-1,0,3,5,9,12]， T = 9
 * 预期输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * <p>
 * 样例 2:
 * 测试输入: n = 6，nums = [-1,0,3,5,9,12], T = 2
 * 预期输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 */

public class test
{
    public int search(int n, int[] nums, int T)
    {
        /********* Begin *********/
        int low = 0;   //最低位和最高位指针
        int high = nums.length - 1;
        int mid = 0;       //中间指针
        while (low <= high)            //循环 循环条件为low<=high
        {
            mid = (low + high) / 2;
            if (nums[mid] == T)         //刚好在中间
            {
                return mid;
            }
            else if (nums[mid] < T)       //在右边
            {
                low = mid + 1;           //低指针变成中间指针+1
            }
            else                      //在左边
            {
                high = mid - 1;          //高位指针
            }
        }
        return -1;                    //没找到

        /********* End *********/
    }

    public static void main(String[] args)
    {
        if (args.length == 0)
        {
            Scanner input = new Scanner(System.in);
            int n = 0;
            //控制台输入变量:n
            int errCount = 0;
            while (true)
            {
                try
                {
                    //min:0
                    //max:1000
                    System.out.print("请输入数组个数：");
                    n = input.nextInt();
                    if (n >= 0 && n <= 1000)
                    {
                        break;
                    }
                    else
                    {
                        errCount++;
                        Toolkit.getDefaultToolkit().beep();
                        if (errCount > 10)
                        {
                            System.err.println("错误次数过多！！！退出");
                            System.exit(1);
                        }
                        System.out.println("输入的数据不在范围内! 范围：[0,1000]");
                    }
                }
                catch (Exception e)
                {
                    errCount++;
                    if (errCount > 5)
                    {
                        Toolkit.getDefaultToolkit().beep();
                        System.err.println("错误次数过多！！！退出");
                        System.exit(1);
                    }
                    else
                    {
                        Toolkit.getDefaultToolkit().beep();
                        System.out.println("输入错误！！！请重新输入！");
                        input.nextLine();
                    }
                }
            }
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++)
            {
                //控制台输入变量:arr[i]
                errCount = 0;
                while (true)
                {
                    try
                    {
                        //min:-1000000
                        //max:1000000
                        System.out.print("请输入第" + (i + 1) + "个数字：");
                        arr[i] = input.nextInt();
                        if (arr[i] >= -10000 && arr[i] <= 1000000)
                        {
                            break;
                        }
                        else
                        {
                            errCount++;
                            Toolkit.getDefaultToolkit().beep();
                            if (errCount > 10)
                            {
                                System.err.println("错误次数过多！！！退出");
                                System.exit(1);
                            }
                            System.out.println("输入的数据不在范围内! 范围：[-10000,1000000]");
                        }
                    }
                    catch (Exception e)
                    {
                        errCount++;
                        if (errCount > 5)
                        {
                            Toolkit.getDefaultToolkit().beep();
                            System.err.println("错误次数过多！！！退出");
                            System.exit(1);
                        }
                        else
                        {
                            Toolkit.getDefaultToolkit().beep();
                            System.out.println("输入错误！！！请重新输入！");
                            input.nextLine();
                        }
                    }
                }
            }

            int search_key;
            //控制台输入变量:search_key
            errCount = 0;
            while (true)
            {
                try
                {
                    //min:-1000000
                    //max:1000000
                    System.out.println("请输入要查找的数字：");
                    search_key = input.nextInt();
                    if (search_key >= -1000000 && search_key <= 1000000)
                    {
                        break;
                    }
                    else
                    {
                        errCount++;
                        Toolkit.getDefaultToolkit().beep();
                        if (errCount > 10)
                        {
                            System.err.println("错误次数过多！！！退出");
                            System.exit(1);
                        }
                        System.out.println("输入的数据不在范围内! 范围：[-1000000,1000000]");
                    }
                }
                catch (Exception e)
                {
                    errCount++;
                    if (errCount > 5)
                    {
                        Toolkit.getDefaultToolkit().beep();
                        System.err.println("错误次数过多！！！退出");
                        System.exit(1);
                    }
                    else
                    {
                        Toolkit.getDefaultToolkit().beep();
                        System.out.println("输入错误！！！请重新输入！");
                        input.nextLine();
                    }
                }
            }

            test t = new test();
            int result = -1;
            Arrays.sort(arr);
            System.out.println("数组：");
            for (int i = 0; i < arr.length; i++)
            {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            System.out.println("关键字：" + search_key);
            result = t.search(n, arr, search_key);
            System.out.println("结果：" + result);
        }
        else if (args.length >= 2)
        {
            int[] arr = new int[args.length - 1];
            int search_key = -1;
            try
            {
                search_key = Integer.parseInt(args[args.length - 1]);
                for (int i = 0; i < args.length - 1; i++)
                {
                    arr[i] = Integer.parseInt(args[i]);
                }

                Arrays.sort(arr);
                System.out.println("数组：");
                for (int i = 0; i < arr.length; i++)
                {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
                System.out.println("搜索关键字：" + search_key);
                test t = new test();
                int result = -1;
                result = t.search(arr.length, arr, search_key);
                System.out.println("结果：" + result);
            }
            catch (Exception e)
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("参数传递异常！！！可能传递了非数字");
            }
        }
        else
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("参数传递错误！！！参数太少,至少为2个");
        }

    }
}

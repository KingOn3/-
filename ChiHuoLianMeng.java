package 数组_吃货联盟;
/**
 * 吃货联盟订餐管理系统
 * 
 * @author 杨卓  zhuo.yang 
 * 
 */
import java.util.Scanner;

public class ChiHuoLianMeng {

	public static void main(String[] args) {
			
			int jieKeNum=100;
			int caiPinNum=100;
			 
			String[] names = new String[jieKeNum]; //订餐人名称
			String[] dishMegs = new String[jieKeNum];// 所选菜品
			int[] times = new int[jieKeNum];// 送餐时间
			String[] addresses = new String[jieKeNum];// 送餐地址
			int[] states = new int[jieKeNum]; // 订单状态： 0：已预定 1：已完成
			double[] sumPrices = new double[jieKeNum];// 总金额
			int numbers[] = new int[jieKeNum]; //份数
			
			Scanner input = new Scanner(System.in);
			//初始化2条订单信息
			names[0]="张一";
			dishMegs[0]="鱼香肉食";
			numbers[0]= 2;
			times[0]=12;
			addresses[0] = "沃尔玛";
			states[0]=0;
			sumPrices[0]=46.0;
			
			names[1]="张二";
			dishMegs[1]="红烧带鱼";
			numbers[1]= 2;
			times[1]=12;
			addresses[1] = "步步高";
			states[1]=0;
			sumPrices[1]=76.0;
			
			// 供选择的菜品信息
			String[] dishNames = new String[caiPinNum];//{ "红烧带鱼", "鱼香肉丝", "时令鲜蔬" }; 菜品名称
			dishNames[0]="红烧带鱼";
			dishNames[1]="鱼香肉丝";
			dishNames[2]="时令鲜蔬";
			double[] prices = new double[caiPinNum];//  { 38.0, 20.0, 10.0 };  菜品单价
			prices[0]=38.0;
			prices[1]=20.0;
			prices[2]=10.0;
			int[] dianZanNums = new int[caiPinNum];
			String fanHui;//全局变量  输入任意值 都返回   重新执行系统
			String manageFanHui;
			System.out.println("欢迎使用“吃货联盟订餐系统”");
			do {
				System.out.println("****************************");
				System.out.println("1、我要订餐");
				System.out.println("2、查看餐袋");
				System.out.println("3、签收订单");
				System.out.println("4、删除订单");
				System.out.println("5、我要点赞");
				System.out.println("6、管理员");
				System.out.println("7、退出系统");
				System.out.println("****************************");
				System.out.print("请选择：");
				int chooseId = input.nextInt();
				boolean isAdd =false;//true :记录找到一个为空的位置，可以插入   false:没有找到
				switch (chooseId) {
				case 1:
					System.out.println("******我要订餐******");
					for(int i = 0;i<names.length;i++){
						if(names[i]==null){
							isAdd = true; //记录已找到一个为空的位置
							
							//执行插入操作
							System.out.println("序号\t菜名\t单价\t点赞数");
							int index=-1;
							int j =0;
							for(;j<dishNames.length;j++){  //遍历数组  显示菜单
								if(dishNames[j]!=null){
									System.out.println((j+1)+"\t"+dishNames[j]+"\t"+prices[j]+"元"+"\t"+dianZanNums[j]+"赞" );
									index=j;
									}
								
							}
							
							System.out.print("请输入订餐人姓名：");
							String name = input.next();
							
							System.out.print("请选择您要点的菜品编号:");
							int  dishId = input.nextInt();
											
							
							while(dishId>index+1||dishId<=0){
								System.out.print("请输入正确的菜品编号：");
								dishId = input.nextInt();//判断输入编号不能为超过数组元素
							}
							
							System.out.print("请选择您需要的份数:");
							int  number = input.nextInt(); // 点餐的份数
							
							while(number<=0){
								System.out.print("请输入正确的份数:"); //判断是否为正确的份数
								number = input.nextInt();
							}
							
							System.out.print("请输入送餐时间（送餐时间是10点至20点间整点送餐）:");
							int time = input.nextInt();
							while(time>20||time<10){
								System.out.print("对不起，您的输入有误，请输入10-20之间的整数：");
									time = input.nextInt();
							 }
							
							System.out.print("请输入送餐地址:");
							String address = input.next();
							//dishMoney 餐费价格
							double peiSongFei=0;//配送费
							double dishMoney=prices[dishId-1]*number;//餐费
							String dishMeg = dishNames[dishId-1];
							
							if(dishMoney>=50){  //当餐费达到50时免去6元配送费
								 peiSongFei = 0.0;
							}else{
								 peiSongFei =6.0;
							}
							double sum = dishMoney+peiSongFei; //总餐费
							
							//订单信息
							System.out.println("\t订餐成功!!!");
							System.out.println("——————————————————————————");
							System.out.println("订餐人姓名："+name);
							System.out.println("送 货 地 址:  "+address);
							System.out.println("送 餐 时 间："+"  "+time+":00点");
							System.out.println();
							System.out.println("———————————菜品————————————\n");
							System.out.println(dishMeg+"\t     "+"x"+number+"     "+prices[dishId-1]);
							System.out.println("餐费："+dishMoney+"元"+"\n配送费："+peiSongFei+"元"+"\n总计："+sum+"元");
							System.out.println("——————————————————————————");
							
							//保存数据
							names[i]=name;
							dishMegs[i]=dishMeg;
							times[i] = time;
							addresses[i]=address;
							sumPrices[i]= sum;
							numbers[i]=number;
							
							break;
						}
					}
					if(!isAdd){
						System.out.println("对不起，您的餐袋已满!!!");
					}
					
					
					
					break;
				case 2:
					System.out.println("******查看餐袋******");
					System.out.println("序号\t订餐人\t餐品信息\t    送餐日期\t送餐地址     总金额\t订单状态");
					for(int i =0;i<names.length;i++){  //遍历数组数据   
						if(names[i]!=null){
						String state = states[i]==0?"已预订":"已完成";
						String time =times[i] +"点";
						System.out.println((i+1)+"\t"+names[i]+"\t"+dishMegs[i]+"  x"+numbers[i]+"   "+time+"      \t"+addresses[i]+"\t   "+sumPrices[i]+"元\t"+state);
						}
					}
					break;
				case 3:
					System.out.println("******签收订单******");
					
					System.out.println("序号\t订餐人\t餐品信息\t    送餐日期\t送餐地址     总金额\t订单状态");
					for(int i =0;i<names.length;i++){  //遍历数组数据    给状态 添加显示   输入0：已预订   输入1：已完成
						if(names[i]!=null){
						String state = states[i]==0?"已预订":"已完成";
						String time =times[i] +"点";
						System.out.println((i+1)+"\t"+names[i]+"\t"+dishMegs[i]+"  x"+numbers[i]+"   "+time+"      \t"+addresses[i]+"\t   "+sumPrices[i]+"元\t"+state);
						}
					}//在签收订单前 能查看订单信息
					
					System.out.print("请选择要签收的订单序号：");
					int qianOrderNum = input.nextInt();
					boolean isQianShou = false;
					for(int i =0;i<names.length;i++){  //判断数组不能为空  并且要判断状态  
						if(names[i]!=null && states[i]==1 && qianOrderNum==i+1){
							System.out.println("您选择的订单已完成签收，不能再次签收！");
							isQianShou = true;
							break;
						}else if(names[i]!=null && states[i]==0 && qianOrderNum==i+1){
							states[i]= 1;
							isQianShou = true;
							System.out.println("订单签收成功!!!");
							break;
						}
					}
					if(!isQianShou){
						System.out.println("没有找到订单");
					}
					
					
					break;
				case 4:
					System.out.println("******删除订单******");
					boolean isDelNum=false;
					int delIndex = -1;//删除订单下标
					
					System.out.println("序号\t订餐人\t餐品信息\t    送餐日期\t送餐地址     总金额\t订单状态");
					for(int i =0;i<names.length;i++){
						if(names[i]!=null){
						String state = states[i]==0?"已预订":"已完成";  //遍历数组数据    给状态 添加显示   输入0：已预订   输入1：已完成  同case3操作
						String time =times[i] +"点";
						System.out.println((i+1)+"\t"+names[i]+"\t"+dishMegs[i]+"  x"+numbers[i]+"   "+time+"      \t"+addresses[i]+"\t   "+sumPrices[i]+"元\t"+state);
						}
					}
					
					System.out.print("请输入要删除的订单序号:");
					int delNum = input.nextInt();
					for(int i =0;i<names.length;i++){
						if(names[i]!=null &&states[i]==0&&delNum==i+1){
							delIndex = i;
							isDelNum = true;
							break;
							
						}else if(names[i]!=null &&states[i]==1&&delNum==i+1){
							System.out.println("您选择的订单已签收，不能删除！");
							isDelNum = true;
							break;
						}
					}
					if(!isDelNum){
						System.out.println("您要删除的订单不存在!!!");
					}
					if(delIndex!=-1){		//依次从后往前赋值
						for(int i =delIndex+1;i<names.length;i++){
							names[i-1] = names[i];
							dishMegs[i-1]=dishMegs[i];
							numbers[i-1] = numbers[i];
							times[i-1]=times[i];
							addresses[i-1]=addresses[i];
							sumPrices[i-1]=sumPrices[i];
							states[i-1]=states[i];
						}
						names[names.length-1] = null;//清空要删除的订单
						dishMegs[names.length-1] =null;
						numbers[names.length-1]=0;
						times[names.length-1]=0;
						addresses[names.length-1]=null;
						sumPrices[names.length-1]=0;
						states[names.length-1]=0;
						System.out.println("删除订单成功!!!");
					}
					break;
				case 5:
					System.out.println("******我要点赞******");
					System.out.println("序号\t菜名\t单价");
					for(int i =0;i<dishNames.length;i++){//循环遍历菜单
						if(dishNames[i]!=null){
						System.out.println((i+1)+"\t"+dishNames[i]+"\t"+prices[i]);
						}
					}
					
					System.out.print("请选择您要点赞的菜品序号：");
					int dianZanXuHao = input.nextInt();
						
					if(dianZanXuHao>dishNames.length||dianZanXuHao<=0){//对数据的处理   判断是否输入正确
						System.out.print("没有该商品，点赞错误! \n请重新输入:");
						
						dianZanXuHao = input.nextInt();
						}
					dianZanNums[dianZanXuHao-1] ++;
					System.out.println("点赞成功！");
					
					
					break;
				case 6:
					System.out.println("******管理员******");
					System.out.println("请输入管理员密码:");
					String shuRu = input.next();//添加一个管理员密码  只要管理员才能添加菜品
					String password = "123";
					if(shuRu.equals(password)){
						do {
							System.out.println("*********************");
							System.out.println("1.添加菜品");
							System.out.println("2.修改菜价");
							System.out.println("3.删除菜品");
							System.out.println("4.今日营业额");
							System.out.println("*********************");
							System.out.println("请输入您的操作(输0返回上级)：");

							int ManagerChoose = input.nextInt();
							if(ManagerChoose==0){
								break;
							}
							switch (ManagerChoose) {
							case 1:
								System.out.println("******添加菜品********");
								System.out.println("序号\t菜名\t单价");//遍历已有菜单
								for(int i =0;i<dishNames.length;i++){
									if(dishNames[i]!=null){
									System.out.println((i+1)+"\t"+dishNames[i]+"\t"+prices[i]);
									}
								}
								System.out.println("菜品名称:");
								String tianJiaDishName = input.next();
								System.out.println("请输入菜品价格:");
								double price = input.nextInt();
								int index=-1;//初始化 插入元素的下标  -1不影响程序的运行
								for(int i =0;i<dishNames.length;i++){ //查找第一个为空的数组  找到它的下标 
									if(dishNames[i]==null){  //
										index = i+1;
										break;
									}
								}
								
								//保存数据
								prices[index-1]=price;
								dianZanNums[index-1]=0;
								dishNames[index-1]=tianJiaDishName;
								System.out.println("添加成功!!!");
								
								
								System.out.println("序号\t菜名\t单价");
								for(int i =0;i<dishNames.length;i++){ // 添加完成后 再次遍历 显示已添加的 菜品名字 和 单价 
									if(dishNames[i]!=null){
										System.out.println((i+1)+"\t"+dishNames[i]+"\t"+prices[i]);
										}
								}
								break;
							case 2:
								int indexCase62=dishNames.length;//定义要修改的菜品下标
								System.out.println("******修改菜价********");
								System.out.println("序号\t菜名\t单价");//遍历已有菜单
								for(int i =0;i<dishNames.length;i++){
									if(dishNames[i]!=null){
									System.out.println((i+1)+"\t"+dishNames[i]+"\t"+prices[i]);
									}
								}
								System.out.print("请输入您要修改的菜品序号：");
								int xiuGaiDishChoose = input.nextInt();
								for (int i = 0; i < dishNames.length; i++) {
									if(dishNames[i]!=null){//找到菜品不为空的最后一个下标
										indexCase62=i;
									}
								}
								if(xiuGaiDishChoose<=0||xiuGaiDishChoose>indexCase62+1){
									System.out.println("没有找到您要删除的序号！！");
									break;
									}else{
										System.out.print("修改后的价格为：");
										double xiuGaiHouDish = input.nextDouble(); 
										prices[xiuGaiDishChoose-1]= xiuGaiHouDish;	//将修改后的价格 赋值给原有的价格上
										System.out.println("修改成功！！！");
									}
								
								
								
								break;
							case 3:
								System.out.println("******删除菜品********");
								System.out.println("序号\t菜名\t单价");//遍历已有菜单
								for(int i =0;i<dishNames.length;i++){
									if(dishNames[i]!=null){
									System.out.println((i+1)+"\t"+dishNames[i]+"\t"+prices[i]);
									}
								}
								System.out.println("请输入您要删除菜品的序号：");
								int delDish = input.nextInt();
								int indexCase63=dishNames.length;//定义要删除的那个菜品下标
								for (int i = 0; i < dishNames.length; i++) {
									if(dishNames[i]!=null){
										indexCase63=i;
									}
								}
								if(delDish<=0||delDish>indexCase63+1){
									System.out.println("没有找到您要删除的序号！！");
									break;
								}else{
									 for (int i = indexCase63; i < dishNames.length; i++) {
										dishNames[i-1]=dishNames[i];
										prices[i-1]=prices[i];
										
									}
									 dishNames[dishNames.length-1]=null;
									 prices[dishNames.length-1]=0;
									 System.out.println("该菜品删除成功！！");
								}
								
								
									
								break;
							case 4:
								System.out.println("******今日营业额********");
								double sum=0;
								for (int i = 0; i < sumPrices.length; i++) {//遍历并累加 sumPrices数组
									sum+=sumPrices[i];
								}
								System.out.println("今日营业额为："+sum);
								break;
							default:
								System.out.println("没有找到该操作！！！");
								break;
							}
							// 当用户输入的功能标号为 1-3之外的数字时，退出循环，否者将会提示输入0返回
							if(ManagerChoose<1||ManagerChoose>4){
								break;
							}
							System.out.println("输入任意值返回!!!");
							manageFanHui = input.next();
							 if(manageFanHui=="0"){
								 break;
							 }
							
							
						} while (manageFanHui!=null);
						
					}else{
						System.out.println("密码输入错误!!!\n您没有此权限!!!");
					}
					break;
				case 7:
					System.out.println("退出系统!!!");
					break;
				default:
					System.out.println("退出系统！！");
					break;
				}
				// 当用户输入的功能标号为 1-5之外的数字时，退出循环，否者将会提示输入0返回
				if(chooseId<1||chooseId>6){
					break;
				}				
				System.out.println("输入任意值返回!");
			 fanHui = input.next();
			} while (fanHui!=null);
			System.out.println("谢谢使用，欢迎下次光临");
	}
}

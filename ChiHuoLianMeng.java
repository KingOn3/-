package �Ի�����;
/**
 * �Ի����˶��͹���ϵͳ
 * 
 * @author ��׿  zhuo.yang 
 * 
 */
import java.util.Scanner;

public class ChiHuoLianMeng {

	public static void main(String[] args) {
		
			
			String[] names = new String[4]; //����������
			String[] dishMegs = new String[4];// ��ѡ��Ʒ
			int[] times = new int[4];// �Ͳ�ʱ��
			String[] addresses = new String[4];// �Ͳ͵�ַ
			int[] states = new int[4]; // ����״̬�� 0����Ԥ�� 1�������
			double[] sumPrices = new double[4];// �ܽ��
			int numbers[] = new int[4]; //����
			
			Scanner input = new Scanner(System.in);
			//��ʼ��2��������Ϣ
			names[0]="��һ";
			dishMegs[0]="������ʳ";
			numbers[0]= 2;
			times[0]=12;
			addresses[0] = "�ֶ���";
			states[0]=0;
			sumPrices[0]=46.0;
			
			names[1]="�Ŷ�";
			dishMegs[1]="���մ���";
			numbers[1]= 2;
			times[1]=12;
			addresses[1] = "������";
			states[1]=0;
			sumPrices[1]=76.0;
			
			// ��ѡ��Ĳ�Ʒ��Ϣ
			String[] dishNames = new String[5];//{ "���մ���", "������˿", "ʱ������" }; ��Ʒ����
			dishNames[0]="���մ���";
			dishNames[1]="������˿";
			dishNames[2]="ʱ������";
			double[] prices = new double[5];//  { 38.0, 20.0, 10.0 };  ��Ʒ����
			prices[0]=38.0;
			prices[1]=20.0;
			prices[2]=10.0;
			int[] dianZanNums = new int[5];
			String fanHui;//ȫ�ֱ���  ��������ֵ ������   ����ִ��ϵͳ
			
			System.out.println("��ӭʹ�á��Ի����˶���ϵͳ��");
			do {
				System.out.println("****************************");
				System.out.println("1����Ҫ����");
				System.out.println("2���鿴�ʹ�");
				System.out.println("3��ǩ�ն���");
				System.out.println("4��ɾ������");
				System.out.println("5����Ҫ����");
				System.out.println("6����Ӳ�Ʒ");
				System.out.println("7���˳�ϵͳ");
				System.out.println("****************************");
				System.out.println("��ѡ��");
				int chooseId = input.nextInt();
				boolean isAdd =false;//true :��¼�ҵ�һ��Ϊ�յ�λ�ã����Բ���   false:û���ҵ�
				switch (chooseId) {
				case 1:
					System.out.println("******��Ҫ����******");
					for(int i = 0;i<names.length;i++){
						if(names[i]==null){
							isAdd = true; //��¼���ҵ�һ��Ϊ�յ�λ��
							
							//ִ�в������
							System.out.println("���\t����\t����\t������");
							int index=-1;
							int j =0;
							for(;j<dishNames.length;j++){  //��������  ��ʾ�˵�
								if(dishNames[j]!=null){
									System.out.println((j+1)+"\t"+dishNames[j]+"\t"+prices[j]+"Ԫ"+"\t"+dianZanNums[j]+"��" );
									index=j;
									}
								
							}
							
							System.out.print("�����붩����������");
							String name = input.next();
							
							System.out.print("��ѡ����Ҫ��Ĳ�Ʒ���:");
							int  dishId = input.nextInt();
											
							
							while(dishId>index+1||dishId<=0){
								System.out.print("��������ȷ�Ĳ�Ʒ��ţ�");
								dishId = input.nextInt();//�ж������Ų���Ϊ��������Ԫ��
							}
							
							System.out.print("��ѡ������Ҫ�ķ���:");
							int  number = input.nextInt(); // ��͵ķ���
							
							while(number<=0){
								System.out.print("��������ȷ�ķ���:"); //�ж��Ƿ�Ϊ��ȷ�ķ���
								number = input.nextInt();
							}
							
							System.out.print("�������Ͳ�ʱ�䣨�Ͳ�ʱ����10����20��������Ͳͣ�:");
							int time = input.nextInt();
							while(time>20||time<10){
								System.out.print("�Բ���������������������10-20֮���������");
									time = input.nextInt();
							 }
							
							System.out.print("�������Ͳ͵�ַ:");
							String address = input.next();
							//dishMoney �ͷѼ۸�
							double peiSongFei=0;//���ͷ�
							double dishMoney=prices[dishId-1]*number;//�ͷ�
							String dishMeg = dishNames[dishId-1];
							
							if(dishMoney>=50){  //���ͷѴﵽ50ʱ��ȥ6Ԫ���ͷ�
								 peiSongFei = 0.0;
							}else{
								 peiSongFei =6.0;
							}
							double sum = dishMoney+peiSongFei; //�ܲͷ�
							
							//������Ϣ
							System.out.println("\t���ͳɹ�!!!");
							System.out.println("����������������������������������������������������");
							System.out.println("������������"+name);
							System.out.println("�� �� �� ַ:  "+address);
							System.out.println("�� �� ʱ �䣺"+"  "+time+":00��");
							System.out.println();
							System.out.println("������������������������Ʒ������������������������\n");
							System.out.println(dishMeg+"\t     "+"x"+number+"     "+prices[dishId-1]);
							System.out.println("�ͷѣ�"+dishMoney+"Ԫ"+"\n���ͷѣ�"+peiSongFei+"Ԫ"+"\n�ܼƣ�"+sum+"Ԫ");
							System.out.println("����������������������������������������������������");
							
							//��������
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
						System.out.println("�Բ������Ĳʹ�����!!!");
					}
					
					
					
					break;
				case 2:
					System.out.println("******�鿴�ʹ�******");
					System.out.println("���\t������\t��Ʒ��Ϣ\t    �Ͳ�����\t�Ͳ͵�ַ     �ܽ��\t����״̬");
					for(int i =0;i<names.length;i++){  //������������   
						if(names[i]!=null){
						String state = states[i]==0?"��Ԥ��":"�����";
						String time =times[i] +"��";
						System.out.println((i+1)+"\t"+names[i]+"\t"+dishMegs[i]+"  x"+numbers[i]+"   "+time+"      \t"+addresses[i]+"\t   "+sumPrices[i]+"Ԫ\t"+state);
						}
					}
					break;
				case 3:
					System.out.println("******ǩ�ն���******");
					
					System.out.println("���\t������\t��Ʒ��Ϣ\t    �Ͳ�����\t�Ͳ͵�ַ     �ܽ��\t����״̬");
					for(int i =0;i<names.length;i++){  //������������    ��״̬ �����ʾ   ����0����Ԥ��   ����1�������
						if(names[i]!=null){
						String state = states[i]==0?"��Ԥ��":"�����";
						String time =times[i] +"��";
						System.out.println((i+1)+"\t"+names[i]+"\t"+dishMegs[i]+"  x"+numbers[i]+"   "+time+"      \t"+addresses[i]+"\t   "+sumPrices[i]+"Ԫ\t"+state);
						}
					}//��ǩ�ն���ǰ �ܲ鿴������Ϣ
					
					System.out.print("��ѡ��Ҫǩ�յĶ�����ţ�");
					int qianOrderNum = input.nextInt();
					boolean isQianShou = false;
					for(int i =0;i<names.length;i++){  //�ж����鲻��Ϊ��  ����Ҫ�ж�״̬  
						if(names[i]!=null && states[i]==1 && qianOrderNum==i+1){
							System.out.println("��ѡ��Ķ��������ǩ�գ������ٴ�ǩ�գ�");
							isQianShou = true;
							break;
						}else if(names[i]!=null && states[i]==0 && qianOrderNum==i+1){
							states[i]= 1;
							isQianShou = true;
							System.out.println("����ǩ�ճɹ�!!!");
							break;
						}
					}
					if(!isQianShou){
						System.out.println("û���ҵ�����");
					}
					
					
					break;
				case 4:
					System.out.println("******ɾ������******");
					boolean isDelNum=false;
					int delIndex = -1;//ɾ�������±�
					
					System.out.println("���\t������\t��Ʒ��Ϣ\t    �Ͳ�����\t�Ͳ͵�ַ     �ܽ��\t����״̬");
					for(int i =0;i<names.length;i++){
						if(names[i]!=null){
						String state = states[i]==0?"��Ԥ��":"�����";  //������������    ��״̬ �����ʾ   ����0����Ԥ��   ����1�������  ͬcase3����
						String time =times[i] +"��";
						System.out.println((i+1)+"\t"+names[i]+"\t"+dishMegs[i]+"  x"+numbers[i]+"   "+time+"      \t"+addresses[i]+"\t   "+sumPrices[i]+"Ԫ\t"+state);
						}
					}
					
					System.out.print("������Ҫɾ���Ķ������:");
					int delNum = input.nextInt();
					for(int i =0;i<names.length;i++){
						if(names[i]!=null &&states[i]==1&&delNum==i+1){
							delIndex = i;
							isDelNum = true;
							break;
							
						}else if(names[i]!=null &&states[i]==0&&delNum==i+1){
							System.out.println("��ѡ��Ķ���δǩ�գ�����ɾ����");
							isDelNum = true;
							break;
						}
					}
					if(!isDelNum){
						System.out.println("��Ҫɾ���Ķ���������!!!");
					}
					if(delIndex!=-1){
						for(int i =delIndex+1;i<names.length;i++){
							names[i-1] = names[i];
							dishMegs[i-1]=dishMegs[i];
							numbers[i-1] = numbers[i];
							times[i-1]=times[i];
							addresses[i-1]=addresses[i];
							sumPrices[i-1]=sumPrices[i];
							states[i-1]=states[i];
						}
						names[names.length-1] = null;
						dishMegs[names.length-1] =null;
						numbers[names.length-1]=0;
						times[names.length-1]=0;
						addresses[names.length-1]=null;
						sumPrices[names.length-1]=0;
						states[names.length-1]=0;
						System.out.println("ɾ�������ɹ�!!!");
					}
					break;
				case 5:
					System.out.println("******��Ҫ����******");
					System.out.println("���\t����\t����");
					for(int i =0;i<dishNames.length;i++){
						if(dishNames[i]!=null){
						System.out.println((i+1)+"\t"+dishNames[i]+"\t"+prices[i]);
						}
					}
					
					System.out.print("��ѡ����Ҫ���޵Ĳ�Ʒ��ţ�");
					int dianZanXuHao = input.nextInt();
						
					if(dianZanXuHao>dishNames.length||dianZanXuHao<=0){
						System.out.print("û�и���Ʒ�����޴���! \n����������:");
						
						dianZanXuHao = input.nextInt();
						}
					dianZanNums[dianZanXuHao-1] ++;
					System.out.println("���޳ɹ���");
					
					
					break;
				case 6:
					System.out.println("******��Ӳ�Ʒ******");
					System.out.println("���������Ա����:");
					String shuRu = input.next();//���һ������Ա����  ֻҪ����Ա������Ӳ�Ʒ
					String password = "123";
					if(shuRu.equals(password)){
						
						System.out.println("���\t����\t����");//�������в˵�
						for(int i =0;i<dishNames.length;i++){
							if(dishNames[i]!=null){
							System.out.println((i+1)+"\t"+dishNames[i]+"\t"+prices[i]);
							}
						}
						System.out.println("��Ʒ����:");
						String tianJiaDishName = input.next();
						System.out.println("�������Ʒ�۸�:");
						double price = input.nextInt();
						int index=-1;//��ʼ�� ����Ԫ�ص��±�  -1��Ӱ����������
						for(int i =0;i<dishNames.length;i++){ //���ҵ�һ��Ϊ�յ�����  �ҵ������±� 
							if(dishNames[i]==null){  //
								index = i+1;
								break;
							}
						}
						
						//��������
						prices[index-1]=price;
						dianZanNums[index-1]=0;
						dishNames[index-1]=tianJiaDishName;
						System.out.println("��ӳɹ�!!!");
						
						
						System.out.println("���\t����\t����");
						for(int i =0;i<dishNames.length;i++){ // �����ɺ� �ٴα��� ��ʾ����ӵ� ��Ʒ���� �� ���� 
							if(dishNames[i]!=null){
								System.out.println((i+1)+"\t"+dishNames[i]+"\t"+prices[i]);
								}
						}
					}else{
						System.out.println("�����������!!!");
					}
					break;
				case 7:
					System.out.println("�˳�ϵͳ!!!");
					break;
				default:
					System.out.println("�˳�ϵͳ����");
					break;
				}
				// ���û�����Ĺ��ܱ��Ϊ 1-5֮�������ʱ���˳�ѭ�������߽�����ʾ����0����
				if(chooseId<1||chooseId>6){
					break;
				}				
				System.out.println("��������ֵ����!");
			 fanHui = input.next();
			} while (fanHui!=null);
			System.out.println("ллʹ�ã���ӭ�´ι���");
	}
}

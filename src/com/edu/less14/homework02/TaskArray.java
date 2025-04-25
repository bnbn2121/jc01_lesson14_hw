package com.edu.less14.homework02;
/*
 * Массив данных хранит только положительные числа.
Напишите метод, позволяющий вставлять сразу несколько элементов в переданный
массив, начиная с определённой позиции.
Предусмотрите случай, когда размер массива недостаточен для размещения всех
новых элементов — в этом случае необходимо создать другой массив, большей
длины, и подменить им первый. Новый массив должен содержать все исходные
элементы и вставленные значения, сохраняя порядок данных.
 */
import java.util.Random;

public class TaskArray {

	public static void main(String[] args) {
		int[] array1 = new int[10];
		int[] array2 = new int[3];
		int[] result;
		initArray(array1);
		print(array1);
		System.out.println();
		initArray(array2);
		print(array2);
		System.out.println();
		result = addIn(array1, array2, 8);
		print(result);
		System.out.println();
		result = addIn(array1, array2, 1);
		print(result);
		
	}

	public static void initArray(int[] array) {
		Random r= new Random();
		for (int i=0; i<array.length;i++) {
			array[i] = r.nextInt(0,10);
		}
	}
	
	public static int[] addIn(int[] array1, int[] array2, int position) {
		if(array2.length>array1.length-position) {
			int []array3 = new int[position+array2.length];
			for (int i=0, j=0;i<array3.length;i++) {
				if(i<position) {
					array3[i]  = array1[i];
				} else {
					array3[i] = array2[j++];
				}
			}
			return array3;
		} else {
			for (int i = position, j = 0; j< array2.length;i++,j++) {
				array1[i] = array2[j];
			}
			return array1;
		}
		
	}
	
	public static void print(int[] array) {
		for (int i = 0; i<array.length;i++) {
			System.out.printf("[%3d]",array[i]);
			if ((i+1)%10==0||i==array.length-1) {
				//System.out.println();
			}
		}
	}
	
}

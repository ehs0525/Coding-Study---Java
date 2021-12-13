package java_1214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_S1_5639_이진검색트리 {

	public static ArrayList<Integer> preorder = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String key = in.readLine();

			if (key == null || key.equals(""))
				break;

			preorder.add(Integer.parseInt(key));
		}

		preToPost(0, preorder.size() - 1);
	}

	public static void preToPost(int root, int last) {
		if (root > last)
			return;

		int rightChild = root + 1;
		while (rightChild <= last && preorder.get(rightChild) < preorder.get(root)) {
			rightChild++;
		}

		preToPost(root + 1, rightChild - 1);
		preToPost(rightChild, last);
		System.out.println(preorder.get(root));
	}

}

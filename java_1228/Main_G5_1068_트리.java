package java_1228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_G5_1068_Ʈ�� {

	public static int N, root, erase;
	public static ArrayList<Integer>[] tree;
	public static int[] leaf;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		tree = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		leaf = new int[N];

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int node = Integer.parseInt(st.nextToken());

			if (node == -1) {
				root = i;
				continue;
			}

			tree[node].add(i);
		}
		erase = Integer.parseInt(in.readLine());

		if (breakRelationship()) { // �θ�-�ڽ� ���� ����
			dfs(root);
		}
		System.out.println(leaf[root]);
	}

	public static void dfs(int parent) {
		if (tree[parent].isEmpty()) {
			leaf[parent] = 1;
		}

		for (int i = 0; i < tree[parent].size(); i++) {
			int child = tree[parent].get(i);
			dfs(child);
			leaf[parent] += leaf[child];
		}
	}

	public static boolean breakRelationship() {
		for (int i = 0; i < N; i++) {
			if (tree[i].contains(erase)) { // �ڽ����� ������ ��带 ���� �ִٸ�
				tree[i].remove(tree[i].indexOf(erase));
				return true;
			}
		}
		return false; // �̱��� �Դٴ� ���� ������ ��尡 ���ٴ� ���̹Ƿ� ������ ��尡 ��Ʈ ��忴�� ����
	}

}

package QLNS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DanhSachTask implements Output {

	private ArrayList<Task> listTask;

	public ArrayList<Task> getListTask() {
		return listTask;
	}

	public void setListTask(ArrayList<Task> dsTask) {
		this.listTask = dsTask;
	}

	public DanhSachTask() {
		this.listTask = new ArrayList<Task>();
	}

	@Override
	public void output() {
		for (Task task : this.listTask) {
			task.output();
		}
	}

	public void taoDuLieu() {
		try {
			FileReader read = new FileReader("src/QLNS/data/Task.txt");
			BufferedReader buf = new BufferedReader(read);
			String line;
			while ((line = buf.readLine()) != null) {
				String[] listInfo = line.split(" # ");
				Task task = new Task(listInfo[0], listInfo[1], Float.parseFloat(listInfo[2]));
				this.listTask.add(task);
			}

			read.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			FileReader read = new FileReader("src/QLNS/data/Task1.txt");
			BufferedReader buf = new BufferedReader(read);
			String line;
			while ((line = buf.readLine()) != null) {
				String[] listInfo = line.split(" # ");
				Task task = new Task(listInfo[0], listInfo[1], Float.parseFloat(listInfo[2]), listInfo[3]);
				this.listTask.add(task);
			}

			read.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
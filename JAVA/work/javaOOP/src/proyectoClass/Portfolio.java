package proyectoClass;

//Clase Portfolio
import java.util.ArrayList;
import java.util.List;

public class Portfolio {
	private ArrayList<Project> projects;

	public Portfolio() {
		projects = new ArrayList<>();
	}

	// Getter y Setter para projects
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}

	public void addProject(Project project) {
		projects.add(project);
	}

	public void removeProject(Project project) {
		projects.remove(project);
	}

	public double getPortfolioCost() {
		double totalCost = 0;
		for (Project project : projects) {
			totalCost += project.getInitialCost();
		}
		return totalCost;
	}

	public void showPortfolio() {
		for (Project project : projects) {
			System.out.println(project.elevatorPitch());
		}
		System.out.println("Costo total del portafolio: " + getPortfolioCost());
	}
}

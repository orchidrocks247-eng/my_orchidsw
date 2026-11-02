package college;

import java.util.List;

public final class CollegeData {
    private CollegeData() {}

    public static College getCollege() {
        List<Department> departments = List.of(
            new Department("Artificial Intelligence & Data Science", "AI & DS",
                "Explore intelligent systems, data analytics and modern computing."),
            new Department("Civil Engineering", "CE",
                "Learn to plan, design and build infrastructure for society."),
            new Department("Computer Science & Engineering", "CSE",
                "Build strong foundations in software, computing and problem solving."),
            new Department("Electronics & Telecommunication Engineering", "E&TC",
                "Study communication, electronics, embedded systems and networks."),
            new Department("Electrical Engineering", "EE",
                "Understand electrical systems, machines, power and control."),
            new Department("Mechanical Engineering", "ME",
                "Develop skills in design, manufacturing, materials and mechanics.")
        );

        return new College(
            "Nagesh Karajagi Orchid College of Engineering & Technology, Solapur",
            "Solapur, Maharashtra, India",
            "Gat No. 16, Solapur–Tuljapur Road, Near Mushroom Ganapati Temple, Tale-Hipparaga, Solapur – 413002",
            "+91 217 299 0051",
            "office@orchidengg.ac.in",
            "https://orchidengg.ac.in/",
            "Autonomous Institute | AICTE approved | NAAC A+ accredited",
            "N. K. Orchid College of Engineering & Technology (NKOCET), Solapur, "
            + "is managed by Pradnya Niketan Education Society, Pune. The institute "
            + "states that it was established in academic year 2008–09. It focuses on "
            + "technical education, practical learning, innovation and overall student development.",
            departments
        );
    }
}

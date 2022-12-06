package models;

public class Elf {

    private String section;
    private int sectionStart;
    private int sectionFinish;

    public Elf(String section) {
        this.section = section;
        setSectionBoundaries();
    }

    public int getSectionStart() {
        return sectionStart;
    }

    public int getSectionFinish() {
        return sectionFinish;
    }

    private void setSectionBoundaries() {
        sectionStart = Integer.valueOf(section.split("-")[0]);
        sectionFinish = Integer.valueOf(section.split("-")[1].split("-")[0]);
    }
}

class DNASequencer {
    private StringBuilder sequence;

    public DNASequencer(int capacity) {
        sequence = new StringBuilder(capacity);
    }

    public void ingestSequence(char[] sensorData) {
        for (char ch : sensorData) {
            sequence.append(ch);
        }
    }

    public void mutateDNA(String target, String replacement) {
        int index = sequence.indexOf(target);

        if (index != -1) {
            sequence.replace(index, index + target.length(), replacement);
        }
    }

    public void displaySequence() {
        System.out.println(sequence.toString());
    }
}

public class Main {
    public static void main(String[] args) {

        DNASequencer dna = new DNASequencer(100000);

        char[] sensorData = {'A', 'C', 'T', 'G', 'A', 'A', 'C'};

        dna.ingestSequence(sensorData);

        System.out.println("Original DNA Sequence:");
        dna.displaySequence();

        dna.mutateDNA("TGA", "CCC");

        System.out.println("DNA Sequence After Mutation:");
        dna.displaySequence();
    }
}

package com.example.android.quiz;

public class Questions {
    private String myQuestions[] = {
            "Which is the nearest star to planet earth? ",
            "At room temperature, which is the only metal that is in liquid form?",
            "Which is the coldest location in the earth? ",
            "The biggest part of the brain is...",
            "This scientist is well known for his theory of relativity. Who is he?",
            "Which is the country which has the Great Barrier Reef?",
            "Where can Coral reefs be found in India?",
            "The United Nations Organization has its Headquarters at...",
            "Objects at the surface of water can be viewed from a submarine under water by using this instrument."
    };

    private String myChoices[][] = {
            {"Sun","Barnard's Star","Sirius A"},
            {"Platinum","Iron","Mercury"},
            {"Arctic","East Antarctica","West Antarctica"},
            {"Cerebellum", "Brain Stem", "Cerebum"},
            {"Thomas Alva Edison", "Albert Einstein", "James Watt"},
            {"Australia","London","New Zealand"},
            {"The Malabar Coast", "Rameshwaram","Trivandrum" },
            {"Bali", "Hague", "New York, USA" },
            {"Stethescope", "Periscope", "Kaleidoscope"}
    };

    private String myCorrectAnswers[] = {"Sun","Mercury","East Antarctica","Cerebum", "Albert einstein","Australia",
                                        "Rameshwarm","New York, USA","Periscope"};

    public String getQuestion(int n){
        String question = myQuestions[n];
        return question;
    }

    public String getChoice1(int n){
        String choice0 = myChoices[n][0];
        return choice0;
    }

    public String getChoice2(int n){
        String choice1 = myChoices[n][1];
        return choice1;
    }

    public String getChoice3(int n){
        String choice2 = myChoices[n][2];
        return choice2;
    }

    public String getCorrectanswer(int n){
        String answer = myCorrectAnswers[n];
        return answer;
    }
}

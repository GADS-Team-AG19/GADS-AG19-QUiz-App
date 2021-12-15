package com.example.gadsag19educationquiz.util

import com.example.gadsag19educationquiz.model.Question
import com.example.gadsag19educationquiz.model.QuestionModel

object QuestionList {

    val science_questions: MutableList<Question> = mutableListOf(
        Question(
            text = "We owe the discovery of electricity to",
            answers = listOf("Faraday", "Newton", "Bacon", "Copernicus")
        ),
        Question(
            text = "All living beings are said to compose of",
            answers = listOf("Cells", "Nose", "DNA", "Legs")
        ),
        Question(
            text = "what distinguishes human from other living things",
            answers = listOf(
                "Capacity to create",
                "Ability to stand on two legs",
                "ability to breathe",
                "ability to walk"
            )
        ),
        Question(
            text = "The evolutionists believe that man evolved directly from",
            answers = listOf("Apes", "Woman", "God", "Fishes")
        ),
        Question(
            text = "What drives scientific inventions ",
            answers = listOf("Curiosity", "Patent", "Wealth", "Copyright")
        ),
        Question(
            text = "Who was the first person to fly into the space",
            answers = listOf(
                "Yuri Gagarin",
                "Abraham Alimatheia",
                "Albert Einstein",
                "Joseph Shevchenko"
            )
        ),
        Question(
            text = "The basic unit of heredity is called:",
            answers = listOf("Gene", "chromosomes", "Family Tree", "Embryo")
        ),
        Question(
            text = "The theory of relativity was formulated by",
            answers = listOf("Einstein", "Newton", "Marx", "Quinne")
        ),
        Question(
            text = "The theory of universal gravitation was intended to explain the phenomenon of",
            answers = listOf(
                "falling objects",
                "steam engines",
                "magnetism",
                "industrial revolution"
            )
        ),
        Question(
            text = "The first man to walk on the moon with his partner was  ",
            answers = listOf("Armstrong", "Einstein", "Neibur", "Gagalin")
        )
    )

    val philosophy_questions: MutableList<Question> = mutableListOf(
        Question(
            text = "Which is not among the most known ancient philosophers of Greek?",
            answers = listOf("Confucius", "Socrates", "Plato", "Aristotle")
        ),
        Question(
            text = "Who was the famous pupil of Socrates?f",
            answers = listOf("Plato", "Aristotle", "Galileo Galilee", "Newton")
        ),
        Question(
            text = "Which is the study of art and beauty?",
            answers = listOf(
                "Aesthetics",
                "Hedonism",
                "Skepticism",
                "Realism"
            )
        ),
        Question(
            text = "Which is not among the fundamental elements out of which all things are made",
            answers = listOf("wood", "fire", "water", "air")
        ),
        Question(
            text = "According to John Locke, humans are born knowing ",
            answers = listOf("Nothing; we begin as \"blank slates.\"", "The environment around", "Family", "The spiritual realm")
        ),
        Question(
            text = "According to early Greek philosophers, all knowledge begins in ______ ",
            answers = listOf(
                "curiosity",
                "experiment",
                "principles",
                "principles"
            )
        ),
        Question(
            text = "We ascribe authority to someone who________ ",
            answers = listOf("is a specialist in a particular field of knowledge", "is not a specialist in particular field of knowledge", "who has experience about a particular situation", "reason well")
        ),
        Question(
            text = "All of these constitute a logical process except",
            answers = listOf("intuition", "judgement", "simple apprehension", "reasoning and argument")
        ),
        Question(
            text = "Logic is the study of______",
            answers = listOf(
                "correct and incorrect reasoning and arguments",
                "correct reasoning and arguments alone",
                "incorrect reasoning and arguments alone",
                "Incorrect propositions alone"
            )
        ),
        Question(
            text = "What is based on inner, personal certainty and conviction  ",
            answers = listOf("belief", "Knowledge", "intuition", "confidence")
        )
    )


    val computer_questions: MutableList<Question> = mutableListOf(
        Question(
            text = "One of the purposes of an operating system is to ...... the peculiarities of specific hardware devices from the user ",
            answers = listOf("hide", "provide", "improvise", "decide")
        ),
        Question(
            text = "The usefulness of the computer depends on the ...... that are written to manipulate it ",
            answers = listOf("programs", "codes", " instructions", "language")
        ),
        Question(
            text = "The Code of a program must be well laid out and explained with ......",
            answers = listOf(
                "comments",
                "punctuations",
                "meanings",
                "reasons"
            )
        ),
        Question(
            text = "What serves the function of a flowchart in expressing the detailed logic of a program. ",
            answers = listOf("pseudocode", "Data flow diagram", "Data dictionary", "All of the options")
        ),
        Question(
            text = "Microsoft ....... application software can be used for preparing slide shows, speeches, seminars, workshop, lectures etc",
            answers = listOf("PowerPoint", "Word", "Access", "Office")
        ),
        Question(
            text = "A robot is ",
            answers = listOf(
                "a a computer-controlled device that can physically manipulate its surroundings",
                "a computer-controlled device that can physically manipulate its activities",
                "a computer-controlled device that can physically design its surroundings",
                "a computer-controlled device"
            )
        ),
        Question(
            text = "CAD stands for ",
            answers = listOf("Computer Aided Design", "Computer Analytical Design", "Computer Aided Diagram", "Computer Allied Design")
        ),
        Question(
            text = " One challenge of the Web-based applications relates to privacy and ....... of personal data stored as an ASP",
            answers = listOf("Security", "Secrecy", "Conflict", "diversion")
        ),
        Question(
            text = "What can infect any files however usually attack .com, .exe, .sys, .bin, .pif or any data files",
            answers = listOf(
                "Viruses",
                "Trojans",
                "Bombs",
                "Jams"
            )
        )
    )
}
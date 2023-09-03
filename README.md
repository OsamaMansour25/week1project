# week 2 questions:

## What are the benefits of using a RESTful API?
Its simple to use as it uses HTTPS methods (GET, POST, DELETE, PUT), which makes it simple to understand. Also it is supported by anything, as we use JSON in this application.


## What is JSON, and why does JSON fit so well with REST?
JSON stands for JavaScript Object Annotation. JSON is very simple to read and can make it easy to work with when you are creating a web application. As mentioned before JSON is used almost everywhere, and is therfore widely supported.

## How you have designed simple CRUD endpoints using spring boot and DTOs to separate api from data  -> Focus on your use of DTO's
The API has been implemented by using a RestController where we have included a method that retrieves data based on a boolean. If the boolean is true (If you are an admin for example) it retrieves all the data that our Entity class has.
Data is sorted out if the boolean is false. In that part of the data, sensitive data has been removed, so it isn't accessible to anybody else than admins.

## What is the advantage of using using DTOs to separate api from data structure when designing rest endpoints?
The first advantage and the key point is to have control over the data exposure. You only send data out that you don't mind is accessible to everybody. It also has a scalability advantage, where you can just add or remove fields from the DTOS, if you want it changed later, you won't need to change a lot of things.
Also this also sorts redundant data sent out to the users/clients, so they only retrieve the data they need and not more or less.

## Explain shortly the concept mocking in relation to software testing
Mocking is a concept in testing that creates fake objects to simulate the behaviour of the real objects of the application.

## How did you mock database access in your tests, using an in-memory database and/or mockito → Refer to your code
I use the annotation @DataJpaTest that later saves data into the in-memory database by using the .save method. Here is the code:

@DataJpaTest
class MemberServiceH2Test {

    @Autowired
    MemberRepository memberRepository;
    MemberService memberService;

    Member m1, m2;  //Talk about references in Java for why we don't add the "isInitialize flag"

    @BeforeEach
    void setUp() {
        m1 = memberRepository.save(new Member("user1", "pw1", "email1", "fn1", "ln1",  "street1", "city1", "zip1"));
        m2 = memberRepository.save(new Member("user2", "pw2", "email1", "fn2", "ln2", "street2", "city2", "zip2"));
        memberService = new MemberService(memberRepository); //Set up memberService with the mock (H2) database
    }
  ## Explain the concept Build Server and the role Github Actions play here
  A build server is a dedicated system that automates the process of building, testing and deploying software applications.
  GitHub Actions allows you to define automated workflows using YAML Files, these can speicfy the steps to build, test and deploy the code whenever changes are pushed to the repository.

  ## Explain maven, relevant parts in maven, and how maven is used in our CI setup. Explain where maven is used by your GitHub Actions Script(s)
  Maven is a tool that automates builds. Maven is configured in the POM file in our project, where we define what dependencies are included. 
  Github provides a default workflow YAML file that provides basic configuration that you can edit to specify to your needs in the project. GitHub Actions uses the script and automates the buld for the project.

  ## Understand and chose cloud service models (IaaS, PaaS, SaaS, DBaaS)for your projects 
  GitHub Actions served as a Platform as a Service (PaaS) for automating CI/CD workflows and testing. 
  GitHub, a Software as a Service (SaaS) platform and managed version control, Github can also be used to work with other team members, but this project is only built by me.
  Microsoft Azure acted as both Infrastructure as a Service (IaaS) by providing virtualized computing resources for hosting my application and Database as a Service (DBaaS) for managing databases.



  

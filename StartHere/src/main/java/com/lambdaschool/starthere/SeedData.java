package com.lambdaschool.starthere;

import com.lambdaschool.starthere.models.*;
import com.lambdaschool.starthere.repository.CampaignRepository;
import com.lambdaschool.starthere.services.CampaignService;
import com.lambdaschool.starthere.services.RoleService;
import com.lambdaschool.starthere.services.UserService;
import org.hibernate.validator.internal.constraintvalidators.bv.money.CurrencyValidatorForMonetaryAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Autowired
    CampaignService campaignService;


    @Override
    public void run(String[] args) throws Exception
    {
        Role r1 = new Role("admin");
        Role r5 = new Role("user");
        Role r2 = new Role("data");
        Role r3 = new Role("supporter");
        Role r4 = new Role("organization");

        roleService.save(r1);
        roleService.save(r2);
        roleService.save(r3);
        roleService.save(r4);
        roleService.save(r5);

        // admin, data, user
        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));
        admins.add(new UserRoles(new User(), r3));
        admins.add(new UserRoles(new User(), r4));
        User u1 = new User("admin", "password", admins);
        u1.getUseremails()
          .add(new Useremail(u1, "admin@email.local"));
        u1.getUseremails()
          .add(new Useremail(u1, "admin@mymail.local"));

        userService.save(u1);

        // data, supporter
        ArrayList<UserRoles> datas = new ArrayList<>();
        datas.add(new UserRoles(new User(), r3));  //supporter
        datas.add(new UserRoles(new User(), r2)); //data
        User u2 = new User("supporter", "password", datas);
        u2.getUseremails()
          .add(new Useremail(u2, "supporter@email.com"));
        userService.save(u2);

        // data, organization
        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2)); //data
        users.add(new UserRoles(new User(), r4)); //organization
        User u3 = new User("organization", "password", users);
        u3.getUseremails()
          .add(new Useremail(u3, "organization@email.com"));
        userService.save(u3);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r5));
        User u4 = new User("Bob", "password", users);
        userService.save(u4);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u5 = new User("Jane", "password", users);
        userService.save(u5);

        // campaigns
        Campaign campaign1 = new Campaign();
        campaign1.setTitle("Lions Need Our Help");
        campaign1.setPhoto("https://d3jkudlc7u70kh.cloudfront.net/lions-fact.jpg");
        campaign1.setLocation("Oregon");
        campaign1.setDescription("Lions are renowned for their majesty and strength. The only social member of the cat family, lions live in prides consisting of females, their young, and either a single male or sometimes a group of two to three males. Primarily nocturnal in nature, females do almost all of the hunting. Lions are the second largest living feline species, second only to the tiger.\n" +
                "\n" +
                "Lions are facing many threats. The population of African lions is less than half of what it was just three decades ago, and continues to decline as lions have been wiped out across much of Africa. Poaching by traffickers seeking “alternatives” to endangered tiger products, coupled with massive habitat loss and loss of prey base due to human settlement, development and climate change have resulted in the US Fish and Wildlife Service proposing to list the African Lion as a threatened species under the Endangered Species Act. Lions are also legally hunted in several countries in Africa, which if done unsustainably, can result in population impacts.\n" +
                "\n" +
                "African lions are still found across a large area of the continent but about 70 percent of the current population exists in only ten major strongholds and its historical range is estimated to have shrunk by nearly 80 percent.\n" +
                "\n" +
                "Studies predict that unless we act now, African lions could be extinct in the wild by 2050. We can’t let that happen. Ongoing protection for lions will be an important step forward in extending the reign of these kings of the jungle.");
        campaign1.setSpecies("lions");
        campaign1.setUrgency("high");
        campaign1.setDonations(0.0);
        campaign1.setFunding_goal(3000.0);
        campaign1.setUserid(4);

        campaignService.save(campaign1);

        Campaign campaign2 = new Campaign();
        campaign2.setTitle("We Must Protect Tigers");
        campaign2.setPhoto("https://rangerrick.org/wp-content/uploads/2018/04/RRSept13_6-11Tigers.jpg");
        campaign2.setLocation("Oregon");
        campaign2.setDescription("The largest member of the feline family, tigers originally inhabited a vast region of land all the way from Turkey throughout South and Southeast Asia to the far eastern shore of the continent. Today, they are found only in South and Southeast Asia, China and scattered parts of the far east of Russia. Tigers are mostly nocturnal and solitary in nature, only socializing during mating season. Interestingly, despite their large size and exceptional land hunting prowess, tigers are very good swimmers and have even been known to hunt in water. Despite their beauty and iconic status, tigers are in great danger. Across their range tigers have been relentlessly massacred by poachers to the point of extinction or becoming endangered, depending on the species.\n" +
                "\n" +
                "Originally there were nine subspecies of tigers, but over the last 80 years three have become completely extinct. The remaining six species of tigers are all considered endangered or critically endangered. The Bengal tiger, the most numerous of the subspecies, still only boasts a wild population of around 2,500.\n" +
                "\n" +
                "If we don’t do something immediately to protect and preserve the remaining population, it has been predicted that all tigers may become extinct in the wild within the next decade. That is one of the reasons why passing strong anti-wildlife trafficking laws and tiger protections are so urgent.");
        campaign2.setSpecies("tigers");
        campaign2.setUrgency("high");
        campaign2.setDonations(0.0);
        campaign2.setFunding_goal(3000.0);
        campaign2.setUserid(4);

        campaignService.save(campaign2);

        Campaign campaign3 = new Campaign();
        campaign3.setTitle("The Fate Of Elephants Rests In Our Hands");
        campaign3.setPhoto("https://images2.minutemediacdn.com/image/upload/c_crop,h_1194,w_2127,x_0,y_39/f_auto,q_auto,w_1100/v1565404115/shape/mentalfloss/86712-gettyimages-1067020092.jpg");
        campaign3.setLocation("Oregon");
        campaign3.setDescription("The two greatest threats to these important animals continue to be poaching and habitat loss. As long as the illegal trade in ivory is allowed to continue we will continue to lose these precious animals. If we cannot protect the world’s largest terrestrial mammal, what does that say about our ability to protect our other wildlife? The fate of elephants rests in our hands, and the continued demand for ivory products places this species in ongoing danger. The need for action is urgent. If we don’t act now to support ivory bans on state, national and international levels, our kids and grandkids could live in a world where these majestic animals don’t exist in the wild; rather, where they learn about elephants from picture books and documentaries.");
        campaign3.setSpecies("elephants");
        campaign3.setUrgency("high");
        campaign3.setDonations(0.0);
        campaign3.setFunding_goal(3000.0);
        campaign3.setUserid(4);

        campaignService.save(campaign3);
    }
}
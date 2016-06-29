package in.recycler;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import in.recycler.fragments.FragmentGrid;
import in.recycler.fragments.FragmentList;
import in.recycler.fragments.FragmentStaggered;

public class MainActivity extends AppCompatActivity {
    TabLayout tabs;
    ViewPager viewPager;
    Adapter adapter;
    Integer[] movies;
    String json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabs = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        movies = new Integer[]{
                R.drawable.x_men,
                R.drawable.independence_day,
                R.drawable.dory,
                R.drawable.batman_vsuperman,
                R.drawable.deadpool,
                R.drawable.zootopia,
                R.drawable.civilwar,
                R.drawable.jurassic,
                R.drawable.back_intheday,
                R.drawable.war_craft,
                R.drawable.terminator,
        };

        setJson();

        setupViewPager(viewPager);
        tabs.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentList().newInstance(getApplicationContext(), json, movies), "List");
        adapter.addFragment(new FragmentGrid().newInstance(getApplicationContext(), json, movies), "Grid");
        adapter.addFragment(new FragmentStaggered().newInstance(getApplicationContext(), json, movies), "Staggered");

        viewPager.setAdapter(adapter);
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {

            super(manager);
        }

        @Override
        public Fragment getItem(int position) {

            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {

            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return mFragmentTitleList.get(position);
        }
    }

    private void setJson() {
        json = "{\n" +
                "\n" +
                "\t\"results\": [{\n" +
                "\t\t\"overview\": \"Since the dawn of civilization, he was worshipped as a god. Apocalypse, the first and most powerful mutant from Marvel’s X-Men universe, amassed the powers of many other mutants, becoming immortal and invincible. Upon awakening after thousands of years, he is disillusioned with the world as he finds it and recruits a team of powerful mutants, including a disheartened Magneto, to cleanse mankind and create a new world order, over which he will reign. As the fate of the Earth hangs in the balance, Raven with the help of Professor X must lead a team of young X-Men to stop their greatest nemesis and save mankind from complete destruction.\",\n" +
                "\t\t\"release_date\": \"2016-05-18\",\n" +
                "\t\t\"original_title\": \"X-Men: Apocalypse\",\n" +
                "\t\t\"title\": \"X-Men: Apocalypse\"\n" +
                "\t}, {\n" +
                "\t\t\"overview\": \"We always knew they were coming back. Using recovered alien technology, the nations of Earth have collaborated on an immense defense program to protect the planet. But nothing can prepare us for the aliens’ advanced and unprecedented force. Only the ingenuity of a few brave men and women can bring our world back from the brink of extinction.\",\n" +
                "\t\t\"release_date\": \"2016-06-22\",\n" +
                "\t\t\"original_title\": \"Independence Day: Resurgence\",\n" +
                "\t\t\"title\": \"Independence Day: Resurgence\"\n" +
                "\t}, {\n" +
                "\t\t\"overview\": \"Dory is a wide-eyed, blue tang fish who suffers from memory loss every 10 seconds or so. The one thing she can remember is that she somehow became separated from her parents as a child. With help from her friends Nemo and Marlin, Dory embarks on an epic adventure to find them. Her journey brings her to the Marine Life Institute, a conservatory that houses diverse ocean species. Dory now knows that her family reunion will only happen if she can save mom and dad from captivity.\",\n" +
                "\t\t\"release_date\": \"2016-06-16\",\n" +
                "\t\t\"original_title\": \"Finding Dory\",\n" +
                "\t\t\"title\": \"Finding Dory\"\n" +
                "\t}, {\n" +
                "\t\t\"overview\": \"Fearing the actions of a god-like Super Hero left unchecked, Gotham City’s own formidable, forceful vigilante takes on Metropolis’s most revered, modern-day savior, while the world wrestles with what sort of hero it really needs. And with Batman and Superman at war with one another, a new threat quickly arises, putting mankind in greater danger than it’s ever known before.\",\n" +
                "\t\t\"release_date\": \"2016-03-23\",\n" +
                "\t\t\"original_title\": \"Batman v Superman: Dawn of Justice\",\n" +
                "\t\t\"title\": \"Batman v Superman: Dawn of Justice\"\n" +
                "\t}, {\n" +
                "\t\t\"overview\": \"Based upon Marvel Comics’ most unconventional anti-hero, DEADPOOL tells the origin story of former Special Forces operative turned mercenary Wade Wilson, who after being subjected to a rogue experiment that leaves him with accelerated healing powers, adopts the alter ego Deadpool. Armed with his new abilities and a dark, twisted sense of humor, Deadpool hunts down the man who nearly destroyed his life.\",\n" +
                "\t\t\"release_date\": \"2016-02-09\",\n" +
                "\t\t\"original_title\": \"Deadpool\",\n" +
                "\t\t\"title\": \"Deadpool\"\n" +
                "\t}, {\n" +
                "\t\t\"overview\": \"Determined to prove herself, Officer Judy Hopps, the first bunny on Zootopia's police force, jumps at the chance to crack her first case - even if it means partnering with scam-artist fox Nick Wilde to solve the mystery.\",\n" +
                "\t\t\"release_date\": \"2016-02-11\",\n" +
                "\t\t\"original_title\": \"Zootopia\",\n" +
                "\t\t\"title\": \"Zootopia\"\n" +
                "\t}, {\n" +
                "\t\t\"overview\": \"Following the events of Age of Ultron, the collective governments of the world pass an act designed to regulate all superhuman activity. This polarizes opinion amongst the Avengers, causing two factions to side with Iron Man or Captain America, which causes an epic battle between former allies.\",\n" +
                "\t\t\"release_date\": \"2016-04-27\",\n" +
                "\t\t\"original_title\": \"Captain America: Civil War\",\n" +
                "\t\t\"title\": \"Captain America: Civil War\"\n" +
                "\t}, {\n" +
                "\t\t\"overview\": \"Twenty-two years after the events of Jurassic Park, Isla Nublar now features a fully functioning dinosaur theme park, Jurassic World, as originally envisioned by John Hammond.\",\n" +
                "\t\t\"release_date\": \"2015-06-09\",\n" +
                "\t\t\"original_title\": \"Jurassic World\",\n" +
                "\t\t\"title\": \"Jurassic World\"\n" +
                "\t}, {\n" +
                "\t\t\"overview\": \"A young boxer is taken under the wing of a mob boss after his mother dies and his father is run out of town for being an abusive alcoholic.\",\n" +
                "\t\t\"release_date\": \"2016-05-20\",\n" +
                "\t\t\"original_title\": \"Back in the Day\",\n" +
                "\t\t\"title\": \"Back in the Day\"\n" +
                "\t}, {\n" +
                "\t\t\"overview\": \"The peaceful realm of Azeroth stands on the brink of war as its civilization faces a fearsome race of invaders: orc warriors fleeing their dying home to colonize another. As a portal opens to connect the two worlds, one army faces destruction and the other faces extinction. From opposing sides, two heroes are set on a collision course that will decide the fate of their family, their people, and their home.\",\n" +
                "\t\t\"release_date\": \"2016-05-25\",\n" +
                "\t\t\"original_title\": \"Warcraft\",\n" +
                "\t\t\"title\": \"Warcraft\"\n" +
                "\t}, {\n" +
                "\t\t\"overview\": \"The year is 2029. John Connor, leader of the resistance continues the war against the machines. At the Los Angeles offensive, John's fears of the unknown future begin to emerge when TECOM spies reveal a new plot by SkyNet that will attack him from both fronts; past and future, and will ultimately change warfare forever.\",\n" +
                "\t\t\"release_date\": \"2015-06-23\",\n" +
                "\t\t\"original_title\": \"Terminator Genisys\",\n" +
                "\t\t\"title\": \"Terminator Genisys\"\n" +
                "\t}]\n" +
                "}";
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

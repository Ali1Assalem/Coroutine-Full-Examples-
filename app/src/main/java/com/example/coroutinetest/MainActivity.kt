package com.example.coroutinetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.coroutinetest.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    val customScope = CoroutineScope(Dispatchers.Default)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //playWithCoroutine()
        playWithFlow()

//        GlobalScope.launch (Dispatchers.Default) {
//            fakeApiRequest()
//        }
//        Log.i("ALI","after coroutine  ")
//        2022-04-25 02:53:24.753 5597-5597/com.example.coroutinetest I/ALI: after coroutine
//        2022-04-25 02:53:27.257 5597-5621/com.example.coroutinetest I/ALI: fake response



//        GlobalScope.launch (Dispatchers.IO) {
//            repeatLogs()
//        }



//        lifecycleScope.launch (Dispatchers.IO) {
//            repeatLogs()
//        }
        //when we use lifecycleScope ,coroutine will stop working if activity finishing



//        customScope.launch(Dispatchers.IO) {
//            repeatLogs()
//        }


//        val job = lifecycleScope.launch (Dispatchers.IO) {
//            repeatLogs()
//        }
//        binding.btn.setOnClickListener{
//            job.cancel()
//        }
        //control job

        //-----------------------------------------------------------------------------//


//        val jobParent= lifecycleScope.launch (Dispatchers.IO) {
//            val job1 =launch { req1() }
//            val job2 =launch { req2() }
//        }

        //inside same coroutine processing is seqential
        //so if you want to run async you must use another coroutine
        //in nested coroutine you dont need to use dispatcher to identify thread
        //cus this nested coroutine will work in parent Dispatecher thread ^_^
        //In this ex we run 2 coroutine in 1 coroutine

//        2022-04-25 04:50:39.269 12350-12446/com.example.coroutinetest I/ALI: res 2
//        2022-04-25 04:50:41.267 12350-12446/com.example.coroutinetest I/ALI: res 1

        //req2 run befroe req1 cus in nested coroutine running is Async

//        binding.btn.setOnClickListener{
//            jobParent.cancel()
//        }


        //---------------------------------------------------------------------------------------------//




//        val jobParent= lifecycleScope.launch (Dispatchers.IO) {
//            var firstRes :String?= null
//            var secondRes :String?= null
//
//            val job1 =launch { firstRes = req1() }
//            val job2 =launch { secondRes = req2() }
//
//            Log.i("ALI",firstRes.toString())
//            Log.i("ALI",secondRes.toString())
//        }
//        2022-04-25 05:36:20.094 19302-19367/com.example.coroutinetest I/ALI: null
//        2022-04-25 05:36:20.094 19302-19367/com.example.coroutinetest I/ALI: null

// we need to run coroutine and ensure job is have avalue before print the data so we use 'join'
        // join wait coroutine to finish


                 //-------------------------------------------------------------------------------------------------//

//        val jobParent= lifecycleScope.launch (Dispatchers.IO) {
//            var firstRes :String?= null
//            var secondRes :String?= null
//
//            val job1 =launch { firstRes = req1() }
//            val job2 =launch { secondRes = req2() }
//
//            job1.join()
//
//            Log.i("ALI",firstRes.toString())
//            Log.i("ALI",secondRes.toString())
//        }
//        2022-04-25 05:40:45.666 21579-21679/com.example.coroutinetest I/ALI: res1
//        2022-04-25 05:40:45.666 21579-21679/com.example.coroutinetest I/ALI: res2

        //--------------------------------------------------------------------------------------------------//

//        val jobParent= lifecycleScope.launch (Dispatchers.IO) {
//            var firstRes :String?= null
//            var secondRes :String?= null
//
//            val job1 =launch { firstRes = req1() }
//            val job2 =launch { secondRes = req2() }
//
//            job2.join()
//
//            Log.i("ALI",firstRes.toString())
//            Log.i("ALI",secondRes.toString())
//        }
//        2022-04-25 05:43:10.456 23074-23133/com.example.coroutinetest I/ALI: null
//        2022-04-25 05:43:10.457 23074-23133/com.example.coroutinetest I/ALI: res2


        //----------------------------------------------------------------------------------------------//

//            val jobParent= lifecycleScope.launch (Dispatchers.IO) {
//            var firstRes :String?= null
//            var secondRes :String?= null
//
//            val job1 =launch { firstRes = req1() }
//            val job2 =launch { secondRes = req2() }
//
//            job2.join()
//            job1.join()
//
//            Log.i("ALI",firstRes.toString())
//            Log.i("ALI",secondRes.toString())
//        }
//        2022-04-25 05:44:44.106 24499-24568/com.example.coroutinetest I/ALI: res1
//        2022-04-25 05:44:44.106 24499-24568/com.example.coroutinetest I/ALI: res2


        //----------------------------------------------------------------------------------------------//

//            val jobParent= lifecycleScope.launch (Dispatchers.IO) {
//
//            val deferred1 =async {  req1() }
//            val deferred2 =async {  req2() }
//
//            Log.i("ALI",deferred1.await())
//            Log.i("ALI",deferred2.await())
//        }

        //await : waiting deffered to finish and get aresult
        // when coroutine have aresult use qwait to blocking another code and waiting coroutine to finist and retaurn a result
//        2022-04-25 05:52:24.459 26672-26763/com.example.coroutinetest I/ALI: res1
//        2022-04-25 05:52:24.460 26672-26763/com.example.coroutinetest I/ALI: res2


        //*Warn* use awit inside coroutine Builder launch
        // if use it inside async , you should make await in another place so you making blockin to another code even coroutine finish

        //----------------------------------------------------------------------------------------------//



    }

//    suspend fun fakeApiRequest(){
//        delay(2500)
//        Log.i("ALI","fake response")
//        Log.i("ALI",Thread.currentThread().name)
//        withContext(Dispatchers.Main) {
//            //binding.txtView.text ="fake response"
//            Log.i("ALI",Thread.currentThread().name)
//        }
//    }



//    suspend fun repeatLogs(){
//        delay(2500)
//        withContext(Dispatchers.Main){
//            startActivity(Intent(this@MainActivity,SecondActivity::class.java))
//            finish()
//        }
//        while (true){
//            Log.i("ALI","Iam working")
//            delay(1000)
//        }
//    }
// this activity will finish but coroutine still working at diferent Thread


               //--------------------------------------------------------------------------------------//


//    lateinit var job1: Job
//    lateinit var job2: Job
//    lateinit var job3: Job
//    lateinit var job4: Job
//    lateinit var job5: Job
//
//    private fun playWithCoroutine(){
//        job1=lifecycleScope.launch{
//            delay(2000)
//            job2=launch {
//                delay(2000)
//                Log.i("ALI","Iam job2")
//                job4=launch {
//                    delay(2000)
//                    Log.i("ALI","Iam job4")
//                }
//                job5=launch {
//                    delay(2000)
//                    Log.i("ALI","Iam job5")
//                }
//            }
//            job3=launch {
//                delay(2000)
//                Log.i("ALI","Iam job3")
//            }
//            Log.i("ALI","Iam job1")
//        }
//    }

    // [ Structured Concerncy ]
//    2022-04-25 06:25:21.167 426-426/com.example.coroutinetest I/ALI: Iam job1
//    2022-04-25 06:25:23.167 426-426/com.example.coroutinetest I/ALI: Iam job2
//    2022-04-25 06:25:23.170 426-426/com.example.coroutinetest I/ALI: Iam job3
//    2022-04-25 06:25:25.172 426-426/com.example.coroutinetest I/ALI: Iam job4
//    2022-04-25 06:25:25.173 426-426/com.example.coroutinetest I/ALI: Iam job5

    // if you cancel job2 ,job3 and job4 will cancelld too
    // cancel job1 , will cancell all jobs


                 //--------------------------------------------------------------------------------------//

    // gettin throw exception in job ????

//    val exceptionHandler = CoroutineExceptionHandler {
//        coroutineContext, throwable ->
//        Log.i("ALI",throwable.message.toString())
//    }
//
//    lateinit var job1: Job
//    lateinit var job2: Job
//    lateinit var job3: Job
//    lateinit var job4: Job
//    lateinit var job5: Job
//
//        private fun playWithCoroutine(){
//        job1=lifecycleScope.launch(exceptionHandler){
//            delay(2000)
//            job2=launch {
//                delay(2000)
//                Log.i("ALI","Iam job2")
//                job4=launch {
//                    delay(2000)
//                    Log.i("ALI","Iam job4")
//                }
//                job5=launch {
//                    delay(2000)
//                    Log.i("ALI","Iam job5")
//                }
//            }
//            job3=launch {
//                delay(2000)
//                val result = 5/0
//                Log.i("ALI","Iam job3")
//            }
//            Log.i("ALI","Iam job1")
//        }
//    }

    // when you have throw exception handled the parent job will end
    // the parent job will not end before all children finished



                        //--------------------------------------------------------------------------------------//

    //flow<Type> Choose type will flow should emitting
//    private fun playWithFlow(){
//        val flow = flow {
//            emit("Ali")
//            delay(1000)
//            emit("hi")
//        }
//
//        lifecycleScope.launch {
//            flow.collect{
//                Log.i("ALI",it)
//            }
//        }
//        2022-04-25 06:50:52.679 8925-8925/com.example.coroutinetest I/ALI: Ali
//        2022-04-25 06:50:53.680 8925-8925/com.example.coroutinetest I/ALI: hi


                     //--------------------------------------------------------------------------------------//

//        private fun playWithFlow(){
//            val flow = flow {
//                for (i in 1..5)
//                    emit(i)
//            }
//
//            lifecycleScope.launch {
//                flow.collect{
//                    Log.i("ALI",it.toString())
//                }
//            }
//            2022-04-25 06:55:45.362 12705-12705/com.example.coroutinetest I/ALI: 1
//            2022-04-25 06:55:45.362 12705-12705/com.example.coroutinetest I/ALI: 2
//            2022-04-25 06:55:45.362 12705-12705/com.example.coroutinetest I/ALI: 3
//            2022-04-25 06:55:45.362 12705-12705/com.example.coroutinetest I/ALI: 4
//            2022-04-25 06:55:45.362 12705-12705/com.example.coroutinetest I/ALI: 5

            //--------------------------------------------------------------------------------------//


//        private fun playWithFlow() {
//            val mflow = flow<Int> {
//                for (i in 1..5) {
//                    emit(i)
//                    delay(1000)
//                }
//            }
//
//            lifecycleScope.launch {
//                mflow.map { it * it }.filter { it % 2 ==1 }.collect{
//                    Log.i("ALI",it.toString())
//                }
//            }
//        }
//    2022-04-25 07:05:54.548 16935-16935/com.example.coroutinetest I/ALI: 1
//    2022-04-25 07:05:56.551 16935-16935/com.example.coroutinetest I/ALI: 9
//    2022-04-25 07:05:58.556 16935-16935/com.example.coroutinetest I/ALI: 25


                 //--------------------------------------------------------------------------------------//


//        private fun playWithFlow() {
//            val mflow = flow<Int> {
//                for (i in 1..5) {
//                    Log.i("ALI","produce ($i) on : ${Thread.currentThread().name}")
//                    emit(i)
//                    delay(1000)
//                }
//            }.flowOn(Dispatchers.Default)
//
//            lifecycleScope.launch {
//                mflow.map { it * it }.filter { it % 2 ==1 }.collect{
//                    Log.i("ALI","consumer ($it) on : ${Thread.currentThread().name}")
//                }
//            }
//        }
//    2022-04-25 07:17:35.961 19318-19427/com.example.coroutinetest I/ALI: produce (1) on : DefaultDispatcher-worker-1
//    2022-04-25 07:17:36.104 19318-19318/com.example.coroutinetest I/ALI: consumer (1) on : main
//    2022-04-25 07:17:36.964 19318-19427/com.example.coroutinetest I/ALI: produce (2) on : DefaultDispatcher-worker-1
//    2022-04-25 07:17:37.966 19318-19427/com.example.coroutinetest I/ALI: produce (3) on : DefaultDispatcher-worker-1
//    2022-04-25 07:17:37.967 19318-19318/com.example.coroutinetest I/ALI: consumer (9) on : main
//    2022-04-25 07:17:38.968 19318-19427/com.example.coroutinetest I/ALI: produce (4) on : DefaultDispatcher-worker-1
//    2022-04-25 07:17:39.972 19318-19427/com.example.coroutinetest I/ALI: produce (5) on : DefaultDispatcher-worker-1
//    2022-04-25 07:17:39.974 19318-19318/com.example.coroutinetest I/ALI: consumer (25) on : main


                      //--------------------------------------------------------------------------------------//

//        private fun playWithFlow() {
//            val mflow = flow<Int> {
//                for (i in 1..5) {
//                    if (i == 2)
//                        throw Exception("Error ^_^")
//                    emit(i)
//                    delay(1000)
//                }
//            }.flowOn(Dispatchers.Default)
//
//            lifecycleScope.launch {
//                mflow.onCompletion {
//                    Log.i("ALI","Complete")
//                }.catch {
//                    Log.i("ALI",it.message.toString())
//                }
//                    .collect{
//                    Log.i("ALI","consumer ($it) on : ${Thread.currentThread().name}")
//                }
//            }
//        }
//    2022-04-25 07:25:43.159 23436-23436/com.example.coroutinetest I/ALI: consumer (1) on : main
//    2022-04-25 07:25:44.123 23436-23436/com.example.coroutinetest I/ALI: Complete
//    2022-04-25 07:25:44.124 23436-23436/com.example.coroutinetest I/ALI: Error ^_^


                //--------------------------------------------------------------------------------------//

    private fun playWithFlow() {
        var mRange= 1..10
        val mList= listOf("ali","ali1","ali2","ali3")
        val mflow=mList.asFlow().onEach {
            delay(1000)
        }

        lifecycleScope.launch {
            mflow.collect {
                Log.i("ALI",it)
            }
        }
    }
//    2022-04-25 07:30:59.434 23901-23901/com.example.coroutinetest I/ALI: ali
//    2022-04-25 07:30:59.434 23901-23901/com.example.coroutinetest I/ALI: ali1
//    2022-04-25 07:30:59.434 23901-23901/com.example.coroutinetest I/ALI: ali2
//    2022-04-25 07:30:59.434 23901-23901/com.example.coroutinetest I/ALI: ali3

              //--------------------------------------------------------------------------------------//








//    suspend fun req1(){
//        delay(5000)
//        Log.i("ALI","res 1")
//    }
//    suspend fun req2(){
//        delay(3000)
//        Log.i("ALI","res 2")
//    }


//    suspend fun req1():String{
//        delay(5000)
//        return "res1"
//    }
//    suspend fun req2():String{
//        delay(3000)
//        return "res2"
//    }

    override fun onDestroy() {
        super.onDestroy()
        customScope.cancel()
    }

}

/*

 To run suspend function we need
- Scope
- Coroutine Builder : 2 Type -> launch , async .
- Dispatcher (optional) : to run coroutine in differnet thread

Dispatcher Types :
 Default , Main , IO , Unconfined

* LifeCycleScope help us to stop coroutine when activity finish , if we dont use it and if coroutine access to ui thread and
 display data in ui and the activity finish will cus memory leak ^_^
 so we use life cycle scope : implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.2.0"

* CoroutineScope : You can choose how long it will coroutine remain worked even after the activity finished

* Coroutines jobs : launch builder return job type
    job : Cancel , isActive ,isCanelled, isCompletted, Children

* Coroutine Builder 'async' return Deferred<T>
* Coroutine Builder 'launch' return job


  flow builder , collector
Flow : return multiple values asynchronously
flow is a stream of data , it is a cold stream
flow is based on Suspend functions

Flow intermediate operators : to change or transform the data
* map , filter
 flow operators are sequntial


 */

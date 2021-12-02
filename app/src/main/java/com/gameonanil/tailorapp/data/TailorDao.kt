package com.gameonanil.tailorapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.gameonanil.tailorapp.data.entity.Clothing
import com.gameonanil.tailorapp.data.entity.Customer
import com.gameonanil.tailorapp.data.entity.CustomerWithClothing
import com.gameonanil.tailorapp.data.entity.Measurement

@Dao
interface TailorDao {
    /**INSERT**/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCustomer(customer: Customer)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertClothing(clothing: Clothing)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMeasurement(measurement: Measurement)

    /**UPDATE**/
    @Update
    fun updateMeasurement(measurement: Measurement)

    @Update
    fun updateClothing(clothing: Clothing)

    /**DELETE**/
    @Delete
    fun deleteClothing(clothing: Clothing)

    @Delete
    fun deleteCustomer(customer: Customer)

    @Delete
    fun deleteMeasurement(measurement: Measurement)

    @Transaction
    @Query("SELECT * FROM customer_table WHERE customerId=:customerId")
    fun getCustomerWithClothing(customerId: Int): LiveData<CustomerWithClothing>

    @Query("SELECT * FROM MEASUREMENT_TABLE WHERE customerId=:customerId")
    fun getMeasurementByCustomerId(customerId: Int): LiveData<Measurement>

    @Query("SELECT * FROM clothing_table WHERE clothingId=:clothingId")
    fun getClothing(clothingId: Int): LiveData<Clothing>


    @Query("SELECT * FROM CUSTOMER_TABLE")
    fun getAllCustomer(): LiveData<List<Customer>>

    @Query("SELECT * FROM MEASUREMENT_TABLE WHERE customerId=:customerId")
    fun getMeasurementByCusId(customerId: Int): Measurement?

    @Query("SELECT * FROM clothing_table WHERE clothingId=:clothingId")
    fun getClothingById(clothingId: Int): Clothing?

    @Query("SELECT * FROM clothing_table WHERE customerId=:customerId")
    fun getClothingListByCusId(customerId: Int): List<Clothing>?

    @Query("SELECT * FROM CUSTOMER_TABLE WHERE customerId=:customerId")
    fun getCurrentCustomer(customerId: Int): Customer


}
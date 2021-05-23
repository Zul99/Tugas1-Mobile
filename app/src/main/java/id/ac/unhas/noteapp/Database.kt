package id.ac.unhas.noteapp

import android.content.Context
import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ContactsContract.CommonDataKinds.Note::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    class NoteDao : id.ac.unhas.noteapp.NoteDao {
        override fun getNotes(): LiveData<List<Note>> {
            TODO("Not yet implemented")
        }

        override suspend fun insertNote(note: Note) {
            TODO("Not yet implemented")
        }

        override suspend fun deleteNote(note: Note) {
            TODO("Not yet implemented")
        }

        override suspend fun updateNote(note: Note) {
            TODO("Not yet implemented")
        }

    }

    companion object {

        private const val DB_NAME = "NOTE_DB"
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                synchronized(AppDatabase::class) {
                    instance = Room
                        .databaseBuilder(
                            context,
                            AppDatabase::class.java,
                            DB_NAME
                        )
                        .build()
                }
            }
            return instance
        }
    }
}
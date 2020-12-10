//package fr.utbm.lo54.servlets;
//
//import org.pentaho.di.core.Const;
//import org.pentaho.di.core.NotePadMeta;
//import org.pentaho.di.core.database.DatabaseMeta;
//import org.pentaho.di.core.exception.KettleException;
//import org.pentaho.di.core.util.EnvUtil;
//import org.pentaho.di.trans.TransHopMeta;
//import org.pentaho.di.trans.TransMeta;
//import org.pentaho.di.trans.step.StepMeta;
//import org.pentaho.di.trans.step.StepMetaInterface;
//import org.pentaho.di.trans.steps.selectvalues.SelectValuesMeta;
//import org.pentaho.di.trans.steps.tableinput.TableInputMeta;
//import org.pentaho.di.trans.steps.tableoutput.TableOutputMeta;
//
//public class TransBuilder {
//    /**
//     * Creates a new Transformation using input parameters such as the tablename to read from.
//     * @param transformationName The name of the transformation
//     * @param sourceDatabaseName The name of the database to read from
//     * @param sourceTableName The name of the table to read from
//     * @param sourceFields The field names we want to read from the source table
//     * @param targetDatabaseName The name of the target database
//     * @param targetTableName The name of the target table we want to write to
//     * @param targetFields The names of the fields in the target table (same number of fields as sourceFields)
//     * @return A new transformation metadata object
//     * @throws KettleException In the rare case something goes wrong
//     */
//
//    public static final TransMeta buildCopyTable(String transformationName,
//                                                 String[] sourceFields, String targetDatabaseName,
//                                                 String targetTableName, String[] targetFields)
//            throws KettleException {
//
//        EnvUtil.environmentInit();
//
//        try
//        {
//            // Create a new transformation...
//            //
//
//            TransMeta transMeta = new TransMeta();
//            transMeta.setName(transformationName);
//
//            // Add the database connections
//            for (int i = 0; i < databasesXML.length; i++) {
//                DatabaseMeta databaseMeta = new DatabaseMeta(databasesXML[i]);
//                transMeta.addDatabase(databaseMeta);
//            }
//
//            DatabaseMeta sourceDBInfo = transMeta.findDatabase(sourceDatabaseName);
//            DatabaseMeta targetDBInfo  = transMeta.findDatabase(targetDatabaseName);
//
//            //
//            // Add a note
//            //
//
//            String note = "Reads information from table [" + sourceTableName+ "] on database [" + sourceDBInfo + "]" + Const.CR;
//            note += "After that, it writes the information to table ["+ targetTableName + "] on database [" + targetDBInfo + "]";
//            NotePadMeta ni = new NotePadMeta(note, 150, 10, -1, -1);
//            transMeta.addNote(ni);
//
//            //
//            // create the source step...
//            //
//
//            String fromstepname = "read from [" + sourceTableName + "]";
//            TableInputMeta tii = new TableInputMeta();
//            tii.setDatabaseMeta(sourceDBInfo);
//            String selectSQL = "SELECT " + Const.CR;
//
//            for (int i = 0; i < sourceFields.length; i++) {
//                if (i > 0) selectSQL += ", "; else selectSQL += " ";
//                selectSQL += sourceFields[i] + Const.CR;
//            }
//            selectSQL += "FROM " + sourceTableName;
//            tii.setSQL(selectSQL);
//
//            StepLoader steploader = StepLoader.getInstance();
//
//            String fromstepid = steploader.getStepPluginID(tii);
//            StepMeta fromstep = new StepMeta(log, fromstepid, fromstepname,(StepMetaInterface) tii);
//            fromstep.setLocation(150, 100);
//            fromstep.setDraw(true);
//            fromstep.setDescription("Reads information from table [" + sourceTableName + "] on database [" + sourceDBInfo + "]");
//            transMeta.addStep(fromstep);
//
//            //
//            // add logic to rename fields
//            // Use metadata logic in SelectValues, use SelectValueInfo...
//            //
//
//            SelectValuesMeta svi = new SelectValuesMeta();
//            svi.allocate(0, 0, sourceFields.length);
//
//            for (int i = 0; i < sourceFields.length; i++) {
//                svi.getMetaName()[i] = sourceFields[i];
//                svi.getMetaRename()[i] = targetFields[i];
//            }
//
//            String selstepname = "Rename field names";
//            String selstepid = steploader.getStepPluginID(svi);
//            StepMeta selstep = new StepMeta(log, selstepid, selstepname, (StepMetaInterface) svi);
//            selstep.setLocation(350, 100);
//            selstep.setDraw(true);
//            selstep.setDescription("Rename field names");
//            transMeta.addStep(selstep);
//
//            TransHopMeta shi = new TransHopMeta(fromstep, selstep);
//            transMeta.addTransHop(shi);
//            fromstep = selstep;
//
//            //
//            // Create the target step...
//            //
//
//            //
//            // Add the TableOutputMeta step...
//            //
//
//            String tostepname = "write to [" + targetTableName + "]";
//            TableOutputMeta toi = new TableOutputMeta();
//            toi.setDatabase(targetDBInfo);
//            toi.setTablename(targetTableName);
//            toi.setCommitSize(200);
//            toi.setTruncateTable(true);
//
//            String tostepid = steploader.getStepPluginID(toi);
//            StepMeta tostep = new StepMeta(log, tostepid, tostepname, (StepMetaInterface) toi);
//            tostep.setLocation(550, 100);
//
//            tostep.setDraw(true);
//            tostep.setDescription("Write information to table [" + targetTableName + "] on database [" + targetDBInfo + "]");
//            transMeta.addStep(tostep);
//
//            //
//            // Add a hop between the two steps...
//            //
//
//            TransHopMeta hi = new TransHopMeta(fromstep, tostep);
//            transMeta.addTransHop(hi);
//
//            // The transformation is complete, return it...
//            return transMeta;
//        } catch (Exception e) {
//            throw new KettleException("An unexpected error occurred creating the new transformation", e);
//        }
//    }
//}
